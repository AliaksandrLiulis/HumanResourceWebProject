package by.htp.project.human_resource.controller.commandprovider;

import javax.servlet.http.HttpServletRequest;
import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;

public class CommandFactory {
	
	private final static CommandFactory instance = new CommandFactory();
	private final CommandProvider commandProvider = new CommandProvider();
	
	private CommandFactory() {
	}

	public static CommandFactory getCommandFactory() {
		return instance;
	}

	public ICommand getCommand(final HttpServletRequest request, final String newCommand) {
		ICommand command = null;
		command = commandProvider.getCommand(request.getParameter(newCommand));
		return command;
	}
}
