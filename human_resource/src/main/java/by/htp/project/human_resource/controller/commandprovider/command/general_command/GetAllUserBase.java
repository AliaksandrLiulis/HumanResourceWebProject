package by.htp.project.human_resource.controller.commandprovider.command.general_command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.service.exception.ServiceException;
import by.htp.project.human_resource.service.factory.ServiceFactory;
import by.htp.project.human_resource.service.interf.IServiceUser;

public class GetAllUserBase implements ICommand{
	
	CheckCommand checkCommand = new CheckCommand();
	HttpSession session = null;
	
	RequestDispatcher dispatcher = null;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = null;
		List<User> allUserBase = null;
		session = request.getSession();
		user = (User) session.getAttribute("user");
		ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
		IServiceUser serviceUser = serviceFactory.getServiceUser();
		try {
			allUserBase = serviceUser.getAllUser();
			request.setAttribute("allUserBase", allUserBase);
			dispatcher = request.getRequestDispatcher(checkCommand.checkRoleForPath(user.getRole()));
			dispatcher.forward(request, response);
		} catch (ServiceException e) {
		
			request.setAttribute("emptyBase", e);
			dispatcher = request.getRequestDispatcher(checkCommand.checkRoleForPath(user.getRole()));
			dispatcher.forward(request, response);
		}
		
	}

}
