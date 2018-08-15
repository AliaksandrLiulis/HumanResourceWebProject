package by.htp.project.human_resource.service.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import by.htp.project.human_resource.controller.commandprovider.command.general_command.CheckCommand;
import by.htp.project.human_resource.dao.exception.DaoException;
import by.htp.project.human_resource.dao.factory.DaoFactory;
import by.htp.project.human_resource.dao.interf.IDaoUser;
import by.htp.project.human_resource.entity.Profile;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.service.constant.ServiceCommandConstant;
import by.htp.project.human_resource.service.constant.ServiceJspPagePath;
import by.htp.project.human_resource.service.constant.ServiceParamConstant;
import by.htp.project.human_resource.service.interf.IServiceUser;

public class ServiceUserImpl implements IServiceUser {

	private HttpSession session = null;
	private final DaoFactory daoFactory = DaoFactory.getDaoFactory();
	private final IDaoUser daoUser = daoFactory.getDaoUser();
	
	public void logInUser(final HttpServletRequest request, final HttpServletResponse response) {

		String nickName = null;
		String password = null;
		String goToPage = null;
		User user = null;
		Profile profile = null;
		RequestDispatcher dispatcher = null;
		CheckCommand checkCommand = null;

		nickName = request.getParameter(ServiceParamConstant.NICKNAME_PARAM);
		password = request.getParameter(ServiceParamConstant.PASSWORD_PARAM);

		CheckLoginParam checkParam = CheckLoginParam.getCheckParam();
		if (checkParam.check(nickName, password)) {
			try {
				user = daoUser.searchUser(nickName, password);
				if (user != null) {
					checkCommand = CheckCommand.getInstance();
					session = request.getSession();
					if (user.getAvaliable() != 0) {
						session.setAttribute(ServiceParamConstant.USER_ATTRIBUTE, user);
						if (user.getProfileId() != 0) {
							profile = daoUser.getProfile(user.getUserId());
							session.setAttribute(ServiceParamConstant.PROFILE_ATTRIBUTE, profile);
						}
						try {
							goToPage = request.getRequestURI() + checkCommand.checkRoleForCommand(user.getRole());
							response.sendRedirect(goToPage);
						} catch (IOException e) {

						}
					} else {
						try {
							goToPage = request.getRequestURI() + ServiceCommandConstant.EXPECT_COMMAND;
							response.sendRedirect(goToPage);
						} catch (IOException e) {

						}
					}
				} else {
					try {
						goToPage = ServiceJspPagePath.PATH_LOGIN_PAGE;
						request.setAttribute("incorrect_params_message", "User does't exist");
						dispatcher = request.getRequestDispatcher(goToPage);
						dispatcher.forward(request, response);
					} catch (ServletException e) {

					} catch (IOException e) {

					}
				}
			} catch (DaoException e) {

			}
		} else {
			try {
				goToPage = ServiceJspPagePath.PATH_LOGIN_PAGE;
				request.setAttribute("incorrect_params_message", "params aren't correct");
				dispatcher = request.getRequestDispatcher(goToPage);
				dispatcher.forward(request, response);
			} catch (ServletException e) {

			} catch (IOException e) {

			}
		}
	}

	@Override
	public void registerUser(final HttpServletRequest request, final HttpServletResponse response) {
		String name = null;
		String surname = null;
		String nickName = null;
		String password = null;
		String email = null;
		String role = null;
		String goToPage = null;
		User user = null;
		RequestDispatcher dispatcher = null;

		name = request.getParameter(ServiceParamConstant.NAME_PARAM);
		surname = request.getParameter(ServiceParamConstant.SURNAME_PARAM);
		nickName = request.getParameter(ServiceParamConstant.NICKNAME_PARAM);
		password = request.getParameter(ServiceParamConstant.PASSWORD_PARAM);
		email = request.getParameter(ServiceParamConstant.EMAIL_PARAM);
		role = request.getParameter(ServiceParamConstant.ROLE_PARAM);

		CheckRegisterParam checkRegisterParam = CheckRegisterParam.getCheckParam();

		if (checkRegisterParam.check(name, surname, nickName, password, email, role)) {
			try {
				if (daoUser.searchUserNickName(nickName)) {
					user = daoUser.addUser(name, surname, nickName, password, email, role);
					if (user != null) {
						goToPage = request.getRequestURI() + ServiceCommandConstant.EXPECT_COMMAND;
						try {
							response.sendRedirect(goToPage);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						goToPage = ServiceJspPagePath.PATH_REGISTRATION_PAGE;
						request.setAttribute("existuser", "user isn't create");
						dispatcher = request.getRequestDispatcher(goToPage);
					}
				} else {
					goToPage = ServiceJspPagePath.PATH_REGISTRATION_PAGE;
					request.setAttribute("existuser", "exist user");
					dispatcher = request.getRequestDispatcher(goToPage);
					try {
						dispatcher.forward(request, response);
					} catch (ServletException e) {
						
					} catch (IOException e) {
						
					}
				}
			} catch (DaoException e) {

			}
		} else
			try {
				goToPage = ServiceJspPagePath.PATH_REGISTRATION_PAGE;

				request.setAttribute("incorrect_params_message", "params aren't correct");
				dispatcher = request.getRequestDispatcher(goToPage);
				dispatcher.forward(request, response);
			} catch (ServletException e) {

			} catch (IOException e) {

			}

	}

	@Override
	public void logOutUser(HttpServletRequest request, HttpServletResponse response) {
		String goToPage = null;
		session = request.getSession();
		session.removeAttribute(ServiceParamConstant.USER_ATTRIBUTE);
		session.removeAttribute(ServiceParamConstant.PROFILE_ATTRIBUTE);
		try {
			goToPage = request.getRequestURI() + ServiceCommandConstant.PATH_MAIN_PAGE_COMMAND;
			response.sendRedirect(goToPage);
		} catch (IOException e) {

		}
	}	
}
