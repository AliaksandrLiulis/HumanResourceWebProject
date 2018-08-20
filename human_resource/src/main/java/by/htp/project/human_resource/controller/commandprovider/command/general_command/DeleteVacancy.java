package by.htp.project.human_resource.controller.commandprovider.command.general_command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;
import by.htp.project.human_resource.service.factory.ServiceFactory;
import by.htp.project.human_resource.service.interf.IServiceHr;

public class DeleteVacancy implements ICommand {

	ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
	IServiceHr serviceHr = serviceFactory.getServiceHr();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		serviceHr.deleteVacancyById(request, response);
	}
}
