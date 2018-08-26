package by.htp.project.human_resource.controller.commandprovider.command.general_command.command_for_jobseeker;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;
import by.htp.project.human_resource.service.service_factory.ServiceFactory;
import by.htp.project.human_resource.service.service_interface.IServiceJobSeeker;

public class GetVacancyForJobSeeker implements ICommand{

	private ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
	private IServiceJobSeeker serviceJobSeeker = serviceFactory.getServiceJobSeeker();
	
	@Override
	public void execute(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		
		serviceJobSeeker.getVacancy(request,response);
	}

}