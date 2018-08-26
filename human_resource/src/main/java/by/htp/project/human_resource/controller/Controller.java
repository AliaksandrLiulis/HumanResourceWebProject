package by.htp.project.human_resource.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project.human_resource.controller.commandprovider.CommandFactory;
import by.htp.project.human_resource.controller.commandprovider.command.general_command.constant_for_command.ParamConst;
import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;

public final class Controller extends HttpServlet {
	
	private static final long serialVersionUID = -8705374380213176470L;
	private final CommandFactory factory = CommandFactory.getCommandFactory();
	private ICommand commands = null;

	public Controller() {
	}

	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)	throws ServletException, IOException {
		commands = factory.getCommand(request, ParamConst.COMMAND);
		commands.execute(request, response);		
	}

	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)	throws ServletException, IOException {
		commands = factory.getCommand(request, ParamConst.COMMAND);
		commands.execute(request, response);		
	}	
}
