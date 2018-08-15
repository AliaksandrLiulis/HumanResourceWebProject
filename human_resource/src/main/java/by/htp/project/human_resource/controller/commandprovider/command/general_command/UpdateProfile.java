package by.htp.project.human_resource.controller.commandprovider.command.general_command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;
import by.htp.project.human_resource.service.factory.ServiceFactory;
import by.htp.project.human_resource.service.interf.IServiceJobSeeker;

public class UpdateProfile implements ICommand {

	ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
	IServiceJobSeeker jobSeeker = serviceFactory.getServiceJobSeeker();

	@Override
	public void execute(final HttpServletRequest request, final HttpServletResponse response) {

		jobSeeker.updateProfile(request, response);

	}
}
