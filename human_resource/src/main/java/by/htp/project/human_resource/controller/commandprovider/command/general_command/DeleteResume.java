package by.htp.project.human_resource.controller.commandprovider.command.general_command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.project.human_resource.controller.commandprovider.command.command_for_page.constForJspPage.JSPPagePath;
import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.service.factory.ServiceFactory;
import by.htp.project.human_resource.service.interf.IServiceUser;

public class DeleteResume implements ICommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = null;
		String goToPage = null;
		int userIdResume = Integer.parseInt(request.getParameter("userResumeId"));
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
		ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
		IServiceUser serviceUser = serviceFactory.getServiceUser();
		session.removeAttribute("user");
		user = serviceUser.deleteResume(userIdResume);	
		session.setAttribute("user", user);
		goToPage = JSPPagePath.PATH_EMPLOYEE_PAGE;
		dispatcher = request.getRequestDispatcher(goToPage);
		dispatcher.forward(request, response);
		
		
	}

}
