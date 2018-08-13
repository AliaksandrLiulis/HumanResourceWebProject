package by.htp.project.human_resource.controller.commandprovider.command.general_command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.project.human_resource.controller.commandprovider.command.command_for_page.constForJspPage.JSPPagePath;
import by.htp.project.human_resource.controller.commandprovider.command.general_command.constForCommand.ParamConst;
import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;

public class LogOut implements ICommand{
	private String goToPage = null;
	
	
	public void execute(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		httpSession.removeAttribute(ParamConst.USER_ATTRIBUTE);
		httpSession.removeAttribute("profile");
		goToPage = request.getRequestURI() + JSPPagePath.PATH_MAIN_PAGE_COMMAND;
		response.sendRedirect(goToPage);
	}
}
