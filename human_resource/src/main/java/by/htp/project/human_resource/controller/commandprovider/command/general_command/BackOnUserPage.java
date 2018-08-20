package by.htp.project.human_resource.controller.commandprovider.command.general_command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.service.impl.checker.CheckCommand;

public class BackOnUserPage implements ICommand{
	
	CheckCommand checkCommand = new CheckCommand();
	HttpSession session = null;	
	RequestDispatcher dispatcher = null;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = null;
		session = request.getSession();
		user = (User) session.getAttribute("user");
		
		dispatcher = request.getRequestDispatcher(checkCommand.checkRoleForPath(user.getRole()));
		dispatcher.forward(request, response);
				
	}

}
