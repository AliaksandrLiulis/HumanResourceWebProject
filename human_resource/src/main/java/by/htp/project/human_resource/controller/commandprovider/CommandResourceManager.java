package by.htp.project.human_resource.controller.commandprovider;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;

public class CommandResourceManager {
	private final static CommandResourceManager instance = new CommandResourceManager();
	private final XMLInputFactory xif = XMLInputFactory.newInstance();
	private Map<String, ICommand> allcommand = new HashMap<>();
	private List<String> command = new ArrayList<>();
	private List<String> value = new ArrayList<>();

	public CommandResourceManager() {
	}

	public static CommandResourceManager getInstance() {
		return instance;
	}

	public Map<String, ICommand> getAllCommand() {
		ClassLoader classLoader = getClass().getClassLoader();
		try (InputStream input = new FileInputStream(classLoader.getResource("command/commands.xml").getFile())){			
			XMLStreamReader reader = xif.createXMLStreamReader(input);

			while (reader.hasNext()) {
				int type = reader.next();
				switch (type) {
				case XMLStreamConstants.CHARACTERS:
					String text = reader.getText().trim();
					if (text.isEmpty()) {
						break;
					}
					if (text.contains("cb")) {
						command.add(text);
					} else {
						value.add(text);
					}
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("File not found!!!!!");
		}
		allcommand = setCommandForMap();
		return allcommand;
	}

	private Map<String, ICommand> setCommandForMap() {
		for (int i = 0; i < command.size(); i++) {
			try {
				allcommand.put(command.get(i), (ICommand) Class.forName(value.get(i)).newInstance());
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return allcommand;
	}
}
