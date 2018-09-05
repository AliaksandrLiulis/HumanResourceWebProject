package by.htp.project.human_resource.controller.commandprovider;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import by.htp.project.human_resource.controller.commandprovider.command.command_for_page.ErrorPage;
import by.htp.project.human_resource.controller.commandprovider.command.general_command.constant_for_command.CommandConst;
import by.htp.project.human_resource.controller.commandprovider.exception.ControllerException;
import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;

/**
 * Instance this Class can get all commands.
 */

public class CommandProvider {

	/** Field CommandResourceManager */
	private final CommandResourceManager commandResourceManager = CommandResourceManager.getInstance();
	/** Field Map<String, ICommand> */
	private Map<String, ICommand> allcommand = null;

	/**
	 * Constructor - creates new object CommandProvider and check field allcommand on
	 * null
	 */
	public CommandProvider() {
		if (allcommand == null || allcommand.size() <= 1) {
			allcommand = getAllCommand();
		}
	}

	/**
	 * method tries get allCommand from commandResourceManager, if not puts in
	 * Map command with ErrorPage	 * 
	 * @return Map
	 */
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

	/**
	 * method compares incoming command with exist and return specific command
	 * @param value name command
	 * @return specific command which implements interface ICommand
	 */
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
