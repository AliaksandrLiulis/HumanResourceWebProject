package by.htp.project.human_resource.service.service_implimentation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.service.impl.checker.CheckCommand;
import by.htp.project.human_resource.service.service_constant.ServiceCommandConstant;
import by.htp.project.human_resource.service.service_constant.ServiceParamConstant;
import by.htp.project.human_resource.service.service_interface.IServiceUtil;

/**
 * Class which has methods for work with Utils
 */

public class ServiceUtilImpl implements IServiceUtil {

	/** Field for logging {@link LoggerFactory} */
	private Logger logger = LoggerFactory.getLogger(ServiceUtilImpl.class);
	private CheckCommand checkCommand = CheckCommand.getInstance();
	/** Field for {@link HttpSession} */
	private HttpSession session = null;
	/** Field for {@link RequestDispatcher} */
	private RequestDispatcher dispatcher = null;
	/** Field for daoFactory */
	private final DaoFactory daoFactory = DaoFactory.getDaoFactory();
	/** Field for daoUser implimentation */
	private final IDaoUser daoUser = daoFactory.getDaoUser();

	@Override
	public void backOnPageByUserRole(final HttpServletRequest request, final HttpServletResponse response) {

		User user = null;

		session = request.getSession();
		user = (User) session.getAttribute(ServiceParamConstant.USER_ATTRIBUTE);

		dispatcher = request.getRequestDispatcher(checkCommand.checkRoleForPath(user.getRole()));

		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			logger.error("ServiceUtilImpl: backOnPageByUserRole:requestDispatcherError" + e);
		}
	}

	@Override
	public void changeLocal(final HttpServletRequest request, final HttpServletResponse response) {

		String goToPage = null;

		String local = request.getParameter(ServiceParamConstant.LOCALE);

		goToPage = (String) request.getSession().getAttribute(ServiceCommandConstant.PREVIOUS_PATH_FOR_LOCALIZATION);

		if (goToPage == null) {
			goToPage = request.getContextPath();
		}

		request.getSession().setAttribute(ServiceParamConstant.LOCALE, local);

		try {
			response.sendRedirect(goToPage);
		} catch (IOException e) {
			logger.error("ServiceUtilImpl: changeLocal:sendRedirectError " + e);
		}
	}

	@Override
	public void writeMessage(final HttpServletRequest request, final HttpServletResponse response) {

		String name = null;
		String email = null;
		String message = null;
		String createDate = null;

		name = request.getParameter(ServiceParamConstant.NAME_PARAM);
		email = request.getParameter(ServiceParamConstant.EMAIL_PARAM);
		message = request.getParameter(ServiceParamConstant.MESSAGE_PARAM);
		SimpleDateFormat dateFormat = new SimpleDateFormat(ServiceParamConstant.SIMPLE_DATE_FORMATE);
		createDate = dateFormat.format(new Date());

		try {

			if (daoUser.createMessage(name, email, createDate, message)) {
				try {
					response.sendRedirect("controllerServlet?command=cb.main_page&sendmess=ok&lettersent=yes");
				} catch (IOException e) {
					logger.error("ServiceUtilImpl: writeMessage:sendRedirectError: " + e);
				}
			} else {
				try {
					response.sendRedirect("controllerServlet?command=cb.main_page&sendmess=ok");
				} catch (IOException e1) {
					logger.error("ServiceUtilImpl: writeMessage:sendRedirectError: " + e1);
				}
			}
		} catch (DaoException e) {
			try {
				logger.error("ServiceUtilImpl: daoException: " + e);
				response.sendRedirect("controllerServlet?command=cb.main_page&sendmess=ok");
			} catch (IOException e1) {
				logger.error("ServiceUtilImpl: writeMessage:sendRedirectError: " + e1);
			}
		}
	}
}
