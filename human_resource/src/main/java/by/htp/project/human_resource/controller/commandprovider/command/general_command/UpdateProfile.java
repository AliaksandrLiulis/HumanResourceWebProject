package by.htp.project.human_resource.controller.commandprovider.command.general_command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.project.human_resource.controller.commandprovider.command.command_for_page.constForJspPage.JSPPagePath;
import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;
import by.htp.project.human_resource.entity.Profile;
import by.htp.project.human_resource.service.factory.ServiceFactory;
import by.htp.project.human_resource.service.interf.IServiceUser;

public class UpdateProfile implements ICommand {
	private HttpSession session = null;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = null;
		String photo = null;
		String phone = null;
		String dateOfBirthDay = null;
		String residence = null;
		String workSpeciality = null;
		String workExpirience = null;
		String education = null;
		String message = null;
		String idUser = null;
		Profile profile = null;
		String goToPage = null;
		RequestDispatcher dispatcher = null;

		ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
		IServiceUser serviceUser = serviceFactory.getServiceUser();

		id = request.getParameter("user_id");
		photo = request.getParameter("photo");
		phone = request.getParameter("phone");
		dateOfBirthDay = request.getParameter("dateOfBirthDay");
		residence = request.getParameter("residence");
		workSpeciality = request.getParameter("workSpeciality");
		workExpirience = request.getParameter("workExpirience");
		education = request.getParameter("education");
		message = request.getParameter("message");

		profile = serviceUser.updateProfile(id, photo, phone, dateOfBirthDay, residence, workSpeciality, workExpirience,
				education, message);
		session = request.getSession();
		session.removeAttribute("profile");
		goToPage = JSPPagePath.PATH_EMPLOYEE_PAGE;
		session.setAttribute("profile", profile);

		dispatcher = request.getRequestDispatcher(goToPage);
		dispatcher.forward(request, response);

	}

}
