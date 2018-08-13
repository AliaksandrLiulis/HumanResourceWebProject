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


public class AddResume implements  ICommand{
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String idUser = null;
		String registrationDate = null;
		String name = null;
		String surName = null;
		String dateOfBirthDay = null;
		String residence = null;
		String phone = null;
		String email = null;
		String education = null;
		String workSpeciality = null;
		String workExpirience = null;
		String aboutUser = null;		
		String photoPath = null;		
		RequestDispatcher dispatcher = null;
		User user = null;
		String goToPage = null;
		
		idUser = request.getParameter("userId");
		registrationDate = request.getParameter("registrationDate");
		name = request.getParameter("name");
		surName = request.getParameter("surname");
		dateOfBirthDay = request.getParameter("dateOfBirthDay");
		residence = request.getParameter("residence");
		phone = request.getParameter("phone");
		email = request.getParameter("email");
		education = request.getParameter("education");
		workSpeciality = request.getParameter("workSpeciality");
		workExpirience = request.getParameter("workExpirience");
		aboutUser = request.getParameter("aboutUser");
		photoPath = request.getParameter("photoPath");
		
		ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
		IServiceUser serviceUser = serviceFactory.getServiceUser();
		
				
		user = serviceUser.addResume(idUser, registrationDate, name, surName, dateOfBirthDay, residence, phone, email,
				education, workSpeciality,workExpirience,aboutUser, photoPath);
		session.removeAttribute("user");
		session.setAttribute("user", user);
		goToPage = JSPPagePath.PATH_EMPLOYEE_PAGE;
		dispatcher = request.getRequestDispatcher(goToPage);
		dispatcher.forward(request, response);
				
	}
}
