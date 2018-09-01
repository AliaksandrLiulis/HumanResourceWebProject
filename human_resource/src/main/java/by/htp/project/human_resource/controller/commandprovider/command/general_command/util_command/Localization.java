package by.htp.project.human_resource.controller.commandprovider.command.general_command.util_command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;
import by.htp.project.human_resource.service.service_factory.ServiceFactory;
import by.htp.project.human_resource.service.service_interface.IServiceUtil;

public class Localization implements ICommand {

	private ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
	private IServiceUtil serviceUtil = serviceFactory.getServiceUtil();

	public void execute(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		
		serviceUtil.changeLocal(request, response);
		
	}
}
