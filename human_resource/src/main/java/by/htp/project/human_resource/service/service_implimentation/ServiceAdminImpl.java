package by.htp.project.human_resource.service.service_implimentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.project.human_resource.dao.dao_exception.DaoException;
import by.htp.project.human_resource.dao.dao_factory.DaoFactory;
import by.htp.project.human_resource.dao.dao_interface.IDaoAdmin;
import by.htp.project.human_resource.entity.Message;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.service.service_constant.ServiceJspPagePath;
import by.htp.project.human_resource.service.service_constant.ServiceParamConstant;
import by.htp.project.human_resource.service.service_interface.IServiceAdmin;

/**
 * Class which has methods for work with Users which have role Administrator
 */

public class ServiceAdminImpl implements IServiceAdmin {

	/** Field for logging {@link LoggerFactory} */
	private Logger logger = LoggerFactory.getLogger(ServiceAdminImpl.class);
	/** Field for daoFactory */
	private final DaoFactory daoFactory = DaoFactory.getDaoFactory();
	/** Field for daoAdmin implementation */
	private final IDaoAdmin daoAdmin = daoFactory.getDaoAdmin();

	@Override
	public void getRegisteredUserByParam(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		String tableName = null;
		RequestDispatcher dispatcher = null;
		int pageNum = 0;
		int countAllUsers = 0;
		String limitLine = null;
		String offsetLine = null;
		int pageCount = 0;
		String goToPage = null;
		List<User> foundedUsers = new ArrayList<>();

		tableName = ServiceParamConstant.USERS_ATTRIBUTE;
		limitLine = request.getParameter(ServiceParamConstant.Limit_LINE_NUMBER);
		offsetLine = request.getParameter(ServiceParamConstant.OFFSET_LINE_NUMBER);
		pageNum = Integer.parseInt(request.getParameter(ServiceParamConstant.PAGE_NUM));

		try {
			countAllUsers = daoAdmin.getCountAllRowsForTable(tableName, 1);
			if (countAllUsers != 0) {
				pageCount = countPaging(countAllUsers, Integer.parseInt(limitLine));
				foundedUsers = daoAdmin.searchAllRegisteredUserByParams(limitLine, offsetLine);
				request.setAttribute("registered", "registered");
				request.setAttribute(ServiceParamConstant.PAGE_NUM, pageNum);
				request.setAttribute(ServiceParamConstant.PAGE_COUNT, pageCount);
				request.setAttribute(ServiceParamConstant.FOUNDED_USERS_ATTRIBUTE, foundedUsers);
			} else {
				goToPage = "controllerServlet?command=cb.admin_page&emptyuser=1";
			}
		} catch (DaoException e) {
			logger.error("ServiceAdminImpl: getRegisteredUserByParam: " + e);
			goToPage = "controllerServlet?command=cb.admin_page&errorgetting=1";
		}
		try {
			if (goToPage == null) {
				goToPage = ServiceJspPagePath.PATH_ADMIN_PAGE;
				dispatcher = request.getRequestDispatcher(goToPage);
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect(goToPage);
			}
		} catch (ServletException | IOException e) {
			logger.error("ServiceAdminImpl: getRegisteredUserByParam: " + e);
			throw e;
		}
	}

	@Override
	public void getUnRegisteredUserByParam(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		String tableName = null;
		RequestDispatcher dispatcher = null;
		int pageNum = 0;
		int countAllUsers = 0;
		String limitLine = null;
		String offsetLine = null;
		int pageCount = 0;
		String goToPage = null;
		List<User> foundedUsers = new ArrayList<>();

		tableName = ServiceParamConstant.USERS_ATTRIBUTE;
		limitLine = request.getParameter(ServiceParamConstant.Limit_LINE_NUMBER);
		offsetLine = request.getParameter(ServiceParamConstant.OFFSET_LINE_NUMBER);
		pageNum = Integer.parseInt(request.getParameter(ServiceParamConstant.PAGE_NUM));

		try {
			countAllUsers = daoAdmin.getCountAllRowsForTable(tableName, 0);
			if (countAllUsers != 0) {
				pageCount = countPaging(countAllUsers, Integer.parseInt(limitLine));
				foundedUsers = daoAdmin.searchAllUnregisteredUserByParams(limitLine, offsetLine);
				request.setAttribute("unregistered", "unregistered");
				request.setAttribute(ServiceParamConstant.PAGE_NUM, pageNum);
				request.setAttribute(ServiceParamConstant.PAGE_COUNT, pageCount);
				request.setAttribute(ServiceParamConstant.FOUNDED_USERS_ATTRIBUTE, foundedUsers);
			} else {
				goToPage = "controllerServlet?command=cb.admin_page&emptyuser=1";
			}
		} catch (DaoException e) {
			logger.error("ServiceAdminImpl: getUnRegisteredUserByParam: " + e);
			goToPage = "controllerServlet?command=cb.admin_page&errorgetting=1";
		}
		try {
			if (goToPage == null) {
				goToPage = ServiceJspPagePath.PATH_ADMIN_PAGE;
				dispatcher = request.getRequestDispatcher(goToPage);
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect(goToPage);
			}
		} catch (ServletException | IOException e) {
			logger.error("ServiceAdminImpl: getUnRegisteredUserByParam: errorSendRedirect" + e);
			throw e;
		}
	}

	@Override
	public void getALLUserByParam(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		String tableName = null;
		RequestDispatcher dispatcher = null;
		int pageNum = 0;
		int countAllUsers = 0;
		String limitLine = null;
		String offsetLine = null;
		int pageCount = 0;
		String goToPage = null;
		List<User> foundedUsers = new ArrayList<>();

		tableName = ServiceParamConstant.USERS_ATTRIBUTE;
		limitLine = request.getParameter(ServiceParamConstant.Limit_LINE_NUMBER);
		offsetLine = request.getParameter(ServiceParamConstant.OFFSET_LINE_NUMBER);
		pageNum = Integer.parseInt(request.getParameter(ServiceParamConstant.PAGE_NUM));

		try {
			countAllUsers = daoAdmin.getCountAllRowsForTable(tableName, -1);
			if (countAllUsers != 0) {
				pageCount = countPaging(countAllUsers, Integer.parseInt(limitLine));
				foundedUsers = daoAdmin.searchAllUserByParams(limitLine, offsetLine);
				request.setAttribute("allusers", "allusers");
				request.setAttribute(ServiceParamConstant.PAGE_NUM, pageNum);
				request.setAttribute(ServiceParamConstant.PAGE_COUNT, pageCount);
				request.setAttribute(ServiceParamConstant.FOUNDED_USERS_ATTRIBUTE, foundedUsers);
			} else {
				goToPage = "controllerServlet?command=cb.admin_page&emptyuser=1";
			}
		} catch (DaoException e) {
			logger.error("ServiceAdminImpl: getUnRegisteredUserByParam: " + e);
			goToPage = "controllerServlet?command=cb.admin_page&errorgetting=1";
		}
		try {
			if (goToPage == null) {
				goToPage = ServiceJspPagePath.PATH_ADMIN_PAGE;
				dispatcher = request.getRequestDispatcher(goToPage);
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect(goToPage);
			}
		} catch (ServletException | IOException e) {
			logger.error("ServiceAdminImpl: getUnRegisteredUserByParam: errorSendRedirect" + e);
			throw e;
		}
	}

	@Override
	public void deleteUser(final HttpServletRequest request, final HttpServletResponse response) throws IOException {

		String idUser = null;
		String goToPage = null;
		idUser = request.getParameter(ServiceParamConstant.USER_ID_PARAM);

		try {
			if (daoAdmin.updateAvaliableFildForUser(Integer.parseInt(idUser), 0)) {
				goToPage = "controllerServlet?command=cb.admin_page&user_delete_message=1";
			} else {
				goToPage = "controllerServlet?command=cb.admin_page&emptyuser=1";
			}
		} catch (DaoException e) {
			logger.error("ServiceAdminImpl: deleteUser: " + e);
			goToPage = "controllerServlet?command=cb.admin_page&errorgetting=1";
		}
		try {
			response.sendRedirect(goToPage);
		} catch (IOException e) {
			logger.error("ServiceAdminImpl: deleteUser: errorSendRedirect" + e);
			throw e;
		}
	}

	@Override
	public void addUser(final HttpServletRequest request, final HttpServletResponse response) throws IOException {

		String idUser = null;
		String goToPage = null;
		idUser = request.getParameter(ServiceParamConstant.USER_ID_PARAM);

		try {
			if (daoAdmin.updateAvaliableFildForUser(Integer.parseInt(idUser), 1)) {
				request.setAttribute("user_add_message", "1");
				goToPage = "controllerServlet?command=cb.admin_page&user_add_message=1";
			}
		} catch (DaoException e) {
			logger.error("ServiceAdminImpl: deleteUser: DaoException" + e);
			goToPage = "controllerServlet?command=cb.admin_page&errorgetting=1";
		}
		try {
			response.sendRedirect(goToPage);
		} catch (IOException e) {
			logger.error("ServiceAdminImpl: deleteUser: errorSendRedirect" + e);
			throw e;
		}
	}

	@Override
	public void getAllMessage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String goToPage = null;

		List<Message> allMessage = new ArrayList<>();
		RequestDispatcher dispatcher = null;

		try {
			allMessage = daoAdmin.searchAllMessage();
			if (allMessage != null) {
				request.setAttribute("all_message", allMessage);
			} else {
				goToPage = "controllerServlet?command=cb.admin_page&emptymessage=1";
			}
		} catch (DaoException e) {
			logger.error("ServiceAdminImpl: getAllMessage: DaoException" + e);
			goToPage = "controllerServlet?command=cb.admin_page&errorgettingmessage=1";
		}
		try {
			if (goToPage == null) {
				goToPage = ServiceJspPagePath.PATH_ADMIN_PAGE;
				dispatcher = request.getRequestDispatcher(goToPage);
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect(goToPage);
			}
		} catch (ServletException | IOException e) {
			logger.error("ServiceAdminImpl: getAllMessage: errorSendRedirect" + e);
			throw e;
		}
	}

	@Override
	public void deleteMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String idMessage = null;
		String goToPage = null;
		idMessage = request.getParameter(ServiceParamConstant.MESSAGE_ID_PARAM);

		try {
			if (daoAdmin.deleteMessage(Integer.parseInt(idMessage))) {
				goToPage = "controllerServlet?command=cb.admin_page&user_message_delete=1";
			} else {
				goToPage = "controllerServlet?command=cb.admin_page&emptyuser=1";
			}
		} catch (DaoException e) {
			logger.error("ServiceAdminImpl: deleteMessage: " + e);
			goToPage = "controllerServlet?command=cb.admin_page&errorgettingmessage=1";
		}
		try {
			response.sendRedirect(goToPage);
		} catch (IOException e) {
			logger.error("ServiceAdminImpl: deleteMessage: errorSendRedirect" + e);
			throw e;
		}
	}

	/**
	 * method for getting count of page
	 * 
	 * @return int
	 */
	private int countPaging(final int commonCount, final int offsetLine) {
		int result = commonCount % offsetLine > 0 ? Math.floorDiv(commonCount, offsetLine) + 1
				: Math.floorDiv(commonCount, offsetLine);
		return result;
	}

}
