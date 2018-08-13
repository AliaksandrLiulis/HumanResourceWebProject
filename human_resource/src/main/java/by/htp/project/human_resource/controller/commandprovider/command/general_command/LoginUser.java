package by.htp.project.human_resource.controller.commandprovider.command.general_command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.htp.project.human_resource.controller.commandprovider.command.command_for_page.constForJspPage.JSPPagePath;
import by.htp.project.human_resource.controller.commandprovider.command.general_command.constForCommand.CommandConst;
import by.htp.project.human_resource.controller.commandprovider.command.general_command.constForCommand.ParamConst;
import by.htp.project.human_resource.controller.commandprovider.interf.ICommand;
import by.htp.project.human_resource.entity.Profile;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.service.exception.ServiceException;
import by.htp.project.human_resource.service.factory.ServiceFactory;
import by.htp.project.human_resource.service.interf.IServiceUser;

public class LoginUser implements ICommand {
	private final Logger logger = LogManager.getLogger(LoginUser.class);
	private HttpSession session = null;

	public void execute(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		List<Object> list = null;
		String nickName = null;
		String password = null;
		String goToPage = null;
		CheckCommand checkCommand = null;
		User user = null;
		Profile profile = null;
		RequestDispatcher dispatcher = null;

		nickName = request.getParameter(ParamConst.NICKNAMEPARAM);
		password = request.getParameter(ParamConst.PASSWORDPARAM);

		ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
		IServiceUser serviceUser = serviceFactory.getServiceUser();

		try {
			list = serviceUser.logInUser(nickName, password);
			
			if (list.size() == 0) {
				goToPage = JSPPagePath.PATH_LOGIN_PAGE;
				request.setAttribute("incorrect_params_message", "isn't correct");
				dispatcher = request.getRequestDispatcher(goToPage);
				dispatcher.forward(request, response);
			}
			if (list.size() == 1) {
				user = (User) list.get(0);
				if (user.getAvaliable() != 0) {
					checkCommand = CheckCommand.getInstance();
					session = request.getSession();
					session.setAttribute(ParamConst.USER_ATTRIBUTE, user);
					goToPage = request.getRequestURI() + checkCommand.checkRoleForCommand(user.getRole());
					response.sendRedirect(goToPage);
				}
			}
			if (list.size() == 2) {
					user = (User) list.get(0);
					profile = (Profile) list.get(1);
					if (user.getAvaliable() != 0) {
						checkCommand = CheckCommand.getInstance();
						session = request.getSession();
						session.setAttribute(ParamConst.USER_ATTRIBUTE, user);
						session.setAttribute("profile", profile);
						goToPage = request.getRequestURI() + checkCommand.checkRoleForCommand(user.getRole());
						response.sendRedirect(goToPage);
					} else {
						goToPage = request.getRequestURI() + CommandConst.EXPECT_COMMAND;
						response.sendRedirect(goToPage);
					}

				}
			}
			
		 catch (ServiceException e) {
			logger.debug(e);
			System.out.println("error");

		}
	}
}
