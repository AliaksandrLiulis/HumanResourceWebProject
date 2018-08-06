package by.htp.project.human_resource.controller.commandprovider.command.main_command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project.human_resource.controller.commandprovider.command.command_for_page.constForJspPage.JSPPagePath;
import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;

public class LogOut implements ICommand{
	String goToPage = null;
	
	public void execute(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		
		goToPage = request.getRequestURI() + JSPPagePath.PATH_MAIN_PAGE_COMMAND;
		response.sendRedirect(goToPage);
	}
}
