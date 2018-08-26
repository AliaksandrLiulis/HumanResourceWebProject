package by.htp.project.human_resource.controller.commandprovider;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import by.htp.project.human_resource.controller.commandprovider.command.command_for_page.ErrorPage;
import by.htp.project.human_resource.controller.commandprovider.command.general_command.constant_for_command.CommandConst;
import by.htp.project.human_resource.controller.commandprovider.exception.ControllerException;
import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;

public class CommandProvider {

	private final CommandResourceManager commandResourceManager = CommandResourceManager.getInstance();
	private Map<String, ICommand> allcommand = null;
	
	public CommandProvider() {
		if (allcommand == null || allcommand.size() <= 1) {
			allcommand = getAllCommand();
		}
	}

	private Map<String, ICommand> getAllCommand() {
		Map<String, ICommand> commands = null;
		try {
			commands = commandResourceManager.getAllCommand();
		} catch (ControllerException e) {
			commands = new HashMap<>();
			commands.put(CommandConst.COMMAND_FOR_ERROR, new ErrorPage());
		}
		return commands;
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
