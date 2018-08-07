package by.htp.project.human_resource.controller.commandprovider.command.command_for_page;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project.human_resource.controller.commandprovider.command.command_for_page.constForJspPage.JSPPagePath;
import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;

public class HrPage implements ICommand{
	
	public void execute(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.PATH_HR_PAGE);
		dispatcher.forward(request, response);
	}
}
