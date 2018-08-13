package by.htp.project.human_resource.controller.commandprovider.command.general_command;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.htp.project.human_resource.controller.commandprovider.command.command_for_page.constForJspPage.JSPPagePath;
import by.htp.project.human_resource.controller.commandprovider.command.general_command.constForCommand.CommandConst;
import by.htp.project.human_resource.controller.commandprovider.command.general_command.constForCommand.ParamConst;
import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;
import by.htp.project.human_resource.entity.Profile;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.service.exception.ServiceException;
import by.htp.project.human_resource.service.factory.ServiceFactory;
import by.htp.project.human_resource.service.interf.IServiceUser;

public class AddProfile implements  ICommand{
	private final Logger logger = LogManager.getLogger(AddProfile.class);
	private HttpSession session = null;
	
	
	@Override
	public void execute(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
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
		List<Object> list = null;
		User user = null;
		Profile profile = null;
		String goToPage = null;
		RequestDispatcher dispatcher = null;
		
		
		ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
		IServiceUser serviceUser = serviceFactory.getServiceUser();
		
		id = request.getParameter("user_id");
		photo = request.getParameter("photo");
		phone=  request.getParameter("phone");
		dateOfBirthDay = request.getParameter("dateOfBirthDay");
		residence = request.getParameter("residence");
		workSpeciality = request.getParameter("workSpeciality");
		workExpirience = request.getParameter("workExpirience");
		education = request.getParameter("education");
		message = request.getParameter("message");
		
		try {
			list = serviceUser.addProfile(id, photo, phone, dateOfBirthDay, residence, workSpeciality, workExpirience, education, message);
			
			if (list != null) {
				if (list.get(0) instanceof User) {
					user = (User)list.get(0);
				}
				if (list.get(1) instanceof Profile) {
					profile = (Profile)list.get(1);
				}
				
				session = request.getSession();
				session.removeAttribute("user");
				goToPage = JSPPagePath.PATH_EMPLOYEE_PAGE;
				session.setAttribute("user", user);
				session.setAttribute("profile", profile);
				
				
				dispatcher = request.getRequestDispatcher(goToPage);
				dispatcher.forward(request, response);
			} 

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
