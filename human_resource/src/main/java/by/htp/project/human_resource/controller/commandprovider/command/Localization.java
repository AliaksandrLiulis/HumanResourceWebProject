package by.htp.project.human_resource.controller.commandprovider.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;

public class Localization implements ICommand {

	private final String LOCALE = "local";
	private final String PREVIOUS_PATH = "previousServletPath";
	
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String goToPage = null;
		String local = request.getParameter(LOCALE);
		goToPage = (String) request.getSession(true).getAttribute(PREVIOUS_PATH);	
		if (goToPage == null) {
			goToPage = request.getContextPath();
		}
		System.out.println(goToPage);
		request.getSession(true).setAttribute("local", local);
		response.sendRedirect(goToPage);
	}
}
