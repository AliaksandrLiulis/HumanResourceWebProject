package by.htp.project.human_resource.controller.commandprovider;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.htp.project.human_resource.controller.commandprovider.command.main_command.LoginUser;
import by.htp.project.human_resource.controller.commandprovider.exception.ControllerException;
import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;

public class CommandResourceManager {

	private final static CommandResourceManager instance = new CommandResourceManager();

	private final String COMMANDS_XML_FILE = "command/commands.xml";
	private final String BEGIN_OF_THE_COMMAND_NAME = "cb";

	private final Logger logger = LogManager.getLogger(LoginUser.class);
	private final XMLInputFactory xif = XMLInputFactory.newInstance();
	private Map<String, ICommand> allcommand = new HashMap<>();
	private List<String> command = new ArrayList<>();
	private List<String> value = new ArrayList<>();

	public CommandResourceManager() {
	}

	public static CommandResourceManager getInstance() {
		return instance;
	}

	public Map<String, ICommand> getAllCommand() throws ControllerException {
		ClassLoader classLoader = getClass().getClassLoader();

		try (InputStream input = new FileInputStream(classLoader.getResource(COMMANDS_XML_FILE).getFile())) {
			XMLStreamReader reader = xif.createXMLStreamReader(input);

			while (reader.hasNext()) {
				int type = reader.next();
				switch (type) {
				case XMLStreamConstants.CHARACTERS:
					String text = reader.getText().trim();
					if (text.isEmpty()) {
						break;
					}
					if (text.contains(BEGIN_OF_THE_COMMAND_NAME)) {
						command.add(text);
					} else {
						value.add(text);
					}
					break;
				}
			}
			allcommand = setCommandForMap();
		} catch (XMLStreamException e) {
			logger.error("CommandResourceManager: getAllCommand: XMLStreamReader error " + e);
			throw new ControllerException();
		} catch (Exception e) {
			logger.error("CommandResourceManager: getAllCommand: ClassLoader error: " + e);
			throw new ControllerException();
		}
		return allcommand;
	}

	private Map<String, ICommand> setCommandForMap() throws ControllerException {
		for (int i = 0; i < command.size(); i++) {
			try {
				allcommand.put(command.get(i), (ICommand) Class.forName(value.get(i)).newInstance());
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				logger.error("CommandResourceManager: setCommandForMap: Command creating error " + e);
				throw new ControllerException();
			}
		}
		return allcommand;
	}
}
