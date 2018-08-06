package by.htp.project.human_resource.controller.commandprovider.command.main_command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.htp.project.human_resource.controller.commandprovider.command.command_for_page.constForJspPage.JSPPagePath;
import by.htp.project.human_resource.controller.commandprovider.command.main_command.constForCommand.CommandConst;
import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.service.exception.ServiceException;
import by.htp.project.human_resource.service.factory.ServiceFactory;
import by.htp.project.human_resource.service.interf.IServiceUser;

public class RegisterUser implements ICommand {
	private final Logger logger = LogManager.getLogger(RegisterUser.class);
	private final String NAMEPARAM = "name";
	private final String SURNAMEPARAM = "surname";
	private final String NICKNAMEPARAM = "nickname";
	private final String PASSWORDPARAM = "password";
	private final String EMAILPARAM = "email";
	private final String ROLEPARAM = "role";

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

		CheckCommand checkCommand = null;
		User user = null;

		name = request.getParameter(NAMEPARAM);
		surname = request.getParameter(SURNAMEPARAM);
		nickName = request.getParameter(NICKNAMEPARAM);
		password = request.getParameter(PASSWORDPARAM);
		email = request.getParameter(EMAILPARAM);
		role = request.getParameter(ROLEPARAM);

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
				checkCommand = CheckCommand.getInstance();
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
