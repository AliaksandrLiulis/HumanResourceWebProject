package by.htp.project.human_resource.controller.commandprovider;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import by.htp.project.human_resource.controller.commandprovider.command.command_for_page.ErrorPage;
import by.htp.project.human_resource.controller.commandprovider.exception.ControllerException;
import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;

public class CommandProvider {

	private final CommandResourceManager commandResourceManager = CommandResourceManager.getInstance();
	private Map<String, ICommand> allcommand = null;
	private final String errorCommand = "cb.error_page";

	public CommandProvider() {
		if (allcommand == null || allcommand.size() <= 1) {
			allcommand = getAllCommand();
		}
	}

	public Map<String, ICommand> getAllCommand() {
		try {
			allcommand = commandResourceManager.getAllCommand();
		} catch (ControllerException e) {
			allcommand = new HashMap<>();
			allcommand.put(errorCommand, new ErrorPage());
		}
		return allcommand;
	}

	public ICommand getCommand(final String commandRequest) {
		ICommand icommand = null;
		Set<Map.Entry<String, ICommand>> entrySet = allcommand.entrySet();
		for (Map.Entry<String, ICommand> pair : entrySet) {
			if (allcommand.size() <= 1) {
				icommand = pair.getValue();
			} else {
				if (commandRequest.equals(pair.getKey())) {
					icommand = pair.getValue();
				}
			}
		}
		return icommand;
	}
}
