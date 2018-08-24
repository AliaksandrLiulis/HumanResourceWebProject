package by.htp.project.human_resource.controller.commandprovider.command.general_command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;
import by.htp.project.human_resource.service.factory.ServiceFactory;
import by.htp.project.human_resource.service.interf.IServiceUser;

public class LogOut implements ICommand{
	
	private ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
	private IServiceUser serviceUser = serviceFactory.getServiceUser();
	
	public void execute(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		
		serviceUser.logOutUser(request, response);	
		
	}
}
