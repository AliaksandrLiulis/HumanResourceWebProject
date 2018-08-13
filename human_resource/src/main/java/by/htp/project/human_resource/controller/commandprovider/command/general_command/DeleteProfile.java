package by.htp.project.human_resource.controller.commandprovider.command.general_command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.service.exception.ServiceException;
import by.htp.project.human_resource.service.factory.ServiceFactory;
import by.htp.project.human_resource.service.interf.IServiceUser;

public class DeleteProfile implements ICommand{
	private User user = null;
	private int userId = 0;
	private HttpSession session = null;
	ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
	IServiceUser serviceUser = serviceFactory.getServiceUser();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		user = (User)session.getAttribute("user");
		userId = user.getId();
		try {
			serviceUser.deleteProfile(userId);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
