package by.htp.project.human_resource.controller.commandprovider.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.service.exception.ServiceException;
import by.htp.project.human_resource.service.factory.ServiceFactory;
import by.htp.project.human_resource.service.interf.IServiceUser;


public class LoginUser implements ICommand {
	private final Logger logger = LogManager.getLogger(LoginUser.class);
	private final String NICKNAMEPARAM = "nickName";
	private final String PASSWORDPARAM = "password";
	private HttpSession session = null;

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nickName = null;
		String password = null;
		String goToPage = null;
		CheckCommand checkCommand = null;
		User user = null;
		RequestDispatcher dispatcher = null;

		nickName = request.getParameter(NICKNAMEPARAM);
		password = request.getParameter(PASSWORDPARAM);

		ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
		IServiceUser serviceUser = serviceFactory.getServiceUser();

		try {
			user = serviceUser.logInUser(nickName, password);
			if (user == null) {
				goToPage = JSPPagePath.PATH_LOGIN_PAGE;
				request.setAttribute("incorrect_params_message", "isn't correct");
				dispatcher = request.getRequestDispatcher(goToPage);
				dispatcher.forward(request, response);
			} else {
				if (user.getAvaliable() != 0) {
					checkCommand = CheckCommand.getInstance();
					session = request.getSession();
					session.setAttribute("user", user);
					goToPage = request.getRequestURI() + checkCommand.check(user.getRole());
					response.sendRedirect(goToPage);
				} else {
					goToPage = request.getRequestURI() + JSPPagePath.EXPECT_COMMAND;
					response.sendRedirect(goToPage);
				}

			}
		} catch (ServiceException e) {
			logger.debug(e);

		}
	}
}