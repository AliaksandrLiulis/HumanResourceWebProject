package by.htp.project.human_resource.controller.commandprovider.command.general_command.command_for_hr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;
import by.htp.project.human_resource.service.service_factory.ServiceFactory;
import by.htp.project.human_resource.service.service_interface.IServiceHr;

public class GetAllRespondedOnVacancy implements ICommand {

	private ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
	private IServiceHr serviceHr = serviceFactory.getServiceHr();

	@Override
	public void execute(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		serviceHr.getAllVacancyResponded(request, response);
		
	}
}
