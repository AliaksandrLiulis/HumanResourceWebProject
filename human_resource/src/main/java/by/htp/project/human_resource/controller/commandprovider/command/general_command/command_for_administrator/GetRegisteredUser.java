package by.htp.project.human_resource.controller.commandprovider.command.general_command.command_for_administrator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;
import by.htp.project.human_resource.service.service_factory.ServiceFactory;
import by.htp.project.human_resource.service.service_interface.IServiceAdmin;

public class GetRegisteredUser implements ICommand {

	private ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
	private IServiceAdmin serviceAdmin = serviceFactory.getServiceAdmin();

	@Override
	public void execute(final HttpServletRequest request, final HttpServletResponse response) {

		serviceAdmin.getRegisteredUserByParam(request, response);

	}
}
