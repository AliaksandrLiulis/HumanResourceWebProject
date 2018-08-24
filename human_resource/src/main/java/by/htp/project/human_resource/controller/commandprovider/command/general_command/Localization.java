package by.htp.project.human_resource.controller.commandprovider.command.general_command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;
import by.htp.project.human_resource.service.constant.ServiceCommandConstant;
import by.htp.project.human_resource.service.constant.ServiceParamConstant;

public class Localization implements ICommand {
	
	public void execute(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		String goToPage = null;
		String local = request.getParameter(ServiceParamConstant.LOCALE);
		goToPage = (String) request.getSession().getAttribute(ServiceCommandConstant.PREVIOUS_PATH_FOR_LOCALIZATION);	
		if (goToPage == null) {
			goToPage = request.getContextPath();
		}
		request.getSession(true).setAttribute(ServiceParamConstant.LOCALE, local);
		response.sendRedirect(goToPage);
	}
}
