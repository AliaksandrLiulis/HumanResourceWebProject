package by.htp.project.human_resource.service.service_implimentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.project.human_resource.dao.dao_exception.DaoException;
import by.htp.project.human_resource.dao.dao_factory.DaoFactory;
import by.htp.project.human_resource.dao.dao_interface.IDaoUser;
import by.htp.project.human_resource.entity.Profile;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.service.impl.checker.CheckCommand;
import by.htp.project.human_resource.service.impl.checker.CheckLoginParam;
import by.htp.project.human_resource.service.impl.checker.CheckRegisterParam;
import by.htp.project.human_resource.service.service_constant.ServiceCommandConstant;
import by.htp.project.human_resource.service.service_constant.ServiceJspPagePath;
import by.htp.project.human_resource.service.service_constant.ServiceParamConstant;
import by.htp.project.human_resource.service.service_interface.IServiceUser;

/**
 * Class which has methods for work with Users
 */

public class ServiceUserImpl implements IServiceUser {

	/** Field for logging {@link LoggerFactory} */
	private static final Logger logger = LoggerFactory.getLogger(ServiceUserImpl.class);
	/** Field for daoFactory */
	private final DaoFactory daoFactory = DaoFactory.getDaoFactory();
	/** Field for daoUser implementation */
	private final IDaoUser daoUser;

	public ServiceUserImpl() {
		this.daoUser = daoFactory.getDaoUser();
	}

	/** Constructor for test */
	public ServiceUserImpl(IDaoUser daoUser) {
		this.daoUser = daoUser;
	}

	public void logInUser(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		String nickName = null;
		String password = null;
		String goToPage = null;
		User user = null;
		Profile profile = null;
		HttpSession session = null;

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
						goToPage = request.getRequestURI() + checkCommand.checkRoleForCommand(user.getRole());

					} else {
						goToPage = request.getRequestURI() + ServiceCommandConstant.EXPECT_COMMAND;
					}
				} else {
					request.setAttribute("user_doesnt_exist", "user doesn't exist");
				}
			} catch (DaoException e) {
				logger.error("ServiceUserImpl: logInUser: DaoException: ", e);
				request.setAttribute("login_error", "user_doesnt login");
			}
		} else {
			request.setAttribute("incorrect_params_message", "params aren't correct");
		}
		goOnPage(request, response, goToPage, "logInUser");
	}

	@Override
	public void registerUser(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		String name = null;
		String surname = null;
		String nickName = null;
		String password = null;
		String email = null;
		String role = null;
		String goToPage = null;
		User user = null;

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
					} else {
						request.setAttribute("user_exist", "exist user");
					}
				} else {
					request.setAttribute("user_exist", "exist user");
				}
			} catch (DaoException e) {
				logger.error("ServiceUserImpl: registerUser: DaoException: ", e);
				request.setAttribute("user_not_registered", "error user registration");
			}
		} else {
			request.setAttribute("incorrect_params_message", "params aren't correct");
		}
		goOnPage(request, response, goToPage, "registerUser");
	}

	@Override
	public void logOutUser(final HttpServletRequest request, final HttpServletResponse response) throws IOException {

		String goToPage = null;
		HttpSession session = null;

		session = request.getSession();
		session.removeAttribute(ServiceParamConstant.USER_ATTRIBUTE);
		session.removeAttribute(ServiceParamConstant.PROFILE_ATTRIBUTE);

		try {
			goToPage = request.getRequestURI() + ServiceCommandConstant.PATH_MAIN_PAGE_COMMAND;
			response.sendRedirect(goToPage);
		} catch (IOException e) {
			logger.error("ServiceUserImpl: logOutUser: sendRedirectError", e);
			throw e;
		}
	}

	/**
	 * method for redirect on other page or other servlet
	 * 
	 * @param String
	 * @param String
	 * @param String
	 * @param HttpServletResponse
	 * @return void
	 */
	private void goOnPage(final HttpServletRequest request, final HttpServletResponse response, String goToPage,
			final String methodName) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		try {
			if (goToPage == null) {
				goToPage = ServiceJspPagePath.PATH_LOGIN_PAGE;
				dispatcher = request.getRequestDispatcher(goToPage);
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect(goToPage);
			}
		} catch (ServletException | IOException e) {
			logger.error("ServiceUserImpl: " + methodName + ": ", e);
			throw e;
		}
	}

}
