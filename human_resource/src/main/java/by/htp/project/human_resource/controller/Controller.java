package by.htp.project.human_resource.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project.human_resource.controller.commandprovider.CommandFactory;
import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;



public final class Controller extends HttpServlet {
	
	private static final long serialVersionUID = -8705374380213176470L;
	private final String COMMAND = "command";
	private CommandFactory factory = CommandFactory.getCommandFactory();
	private ICommand commands = null;

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		commands = factory.getCommand(request, COMMAND);
		commands.execute(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		commands = factory.getCommand(request, COMMAND);
		commands.execute(request, response);		
	}	
}
