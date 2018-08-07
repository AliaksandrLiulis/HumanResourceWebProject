package by.htp.project.human_resource.controller.commandprovider.command.main_command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project.human_resource.controller.commandprovider.command.main_command.constForCommand.CommandConst;
import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;

public class Localization implements ICommand {
	
	public void execute(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		String goToPage = null;
		String local = request.getParameter(CommandConst.LOCALE);
		goToPage = (String) request.getSession().getAttribute(CommandConst.PREVIOUS_PATH_FOR_LOCALIZATION);	
		if (goToPage == null) {
			goToPage = request.getContextPath();
		}
		request.getSession(true).setAttribute(CommandConst.LOCALE, local);
		response.sendRedirect(goToPage);
	}
}
