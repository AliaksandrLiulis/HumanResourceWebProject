package by.htp.project.human_resource.controller.commandprovider.command.general_command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.htp.project.human_resource.controller.commandprovider.command.command_for_page.constForJspPage.JSPPagePath;
import by.htp.project.human_resource.controller.commandprovider.command.general_command.constForCommand.CommandConst;
import by.htp.project.human_resource.controller.commandprovider.command.general_command.constForCommand.ParamConst;
import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.service.exception.ServiceException;
import by.htp.project.human_resource.service.factory.ServiceFactory;
import by.htp.project.human_resource.service.interf.IServiceUser;

public class RegisterUser implements ICommand {
	private final Logger logger = LogManager.getLogger(RegisterUser.class);
	
	@Override
	public void execute(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		String name = null;
		String surname = null;
		String nickName = null;
		String password = null;
		String email = null;
		String role = null;
		String goToPage = null;
		RequestDispatcher dispatcher = null;
		User user = null;

		name = request.getParameter(ParamConst.NAMEPARAM);
		surname = request.getParameter(ParamConst.SURNAMEPARAM);
		nickName = request.getParameter(ParamConst.NICKNAMEPARAM);
		password = request.getParameter(ParamConst.PASSWORDPARAM);
		email = request.getParameter(ParamConst.EMAILPARAM);
		role = request.getParameter(ParamConst.ROLEPARAM);

		ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
		IServiceUser serviceUser = serviceFactory.getServiceUser();

		try {
			user = serviceUser.registerUser(name, surname, nickName, password, email, role);
			if (user == null) {
				goToPage = JSPPagePath.PATH_REGISTRATION_PAGE;
				request.setAttribute("existuser", "exist user");
				dispatcher = request.getRequestDispatcher(goToPage);
				dispatcher.forward(request, response);
			} else {
			if (user.getAvaliable() != 1) {
					goToPage = request.getRequestURI() + CommandConst.EXPECT_COMMAND;
					response.sendRedirect(goToPage);
				}				
			}
		} catch (ServiceException e) {
			for (StackTraceElement stackTraceElement : e.getStackTrace()) {
				logger.info(stackTraceElement);
			}
		}
	}
}
