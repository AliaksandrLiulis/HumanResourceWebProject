package by.htp.project.human_resource.controller.commandprovider;

import javax.servlet.http.HttpServletRequest;
import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;

/**
 * The Class is Singleton. Instance this class has methods wich can return
 * command for invoker.
 */

public class CommandFactory {

	/** Field CommandFactory */
	private final static CommandFactory instance = new CommandFactory();
	/** Field CommandProvider */
	private final CommandProvider commandProvider = new CommandProvider();

	private CommandFactory() {
	}

	/**
	 * method gets instance CommandFactory
	 * 
	 * @return instance CommandFactory
	 * 
	 */

	public static CommandFactory getCommandFactory() {
		return instance;
	}

	/**
	 * method returns specific command
	 * 
	 * @param request    object that contains the request the client has made of the
	 *                   Servlet
	 * @param newCommand command which gets from client
	 * @return specific command which implements interface ICommand
	 */

	public ICommand getCommand(final HttpServletRequest request, final String newCommand) {
		ICommand command = null;
		command = commandProvider.getCommand(request.getParameter(newCommand));
		return command;
	}
}
