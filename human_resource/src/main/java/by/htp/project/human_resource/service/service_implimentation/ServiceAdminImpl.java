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
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.service.service_constant.ServiceJspPagePath;
import by.htp.project.human_resource.service.service_constant.ServiceParamConstant;
import by.htp.project.human_resource.service.service_interface.IServiceAdmin;

public class ServiceAdminImpl implements IServiceAdmin {

	private Logger logger = LoggerFactory.getLogger(ServiceAdminImpl.class);
	private final DaoFactory daoFactory = DaoFactory.getDaoFactory();
	private final IDaoAdmin daoAdmin = daoFactory.getDaoAdmin();
	private final String GO_TO_PAGE = ServiceJspPagePath.PATH_ADMIN_PAGE;

	@Override
	public void getRegisteredUserByParam(final HttpServletRequest request, final HttpServletResponse response) {

		String tableName = null;
		RequestDispatcher dispatcher = null;
		int pageNum = 0;
		int countAllUsers = 0;
		String limitLine = null;
		String offsetLine = null;
		int pageCount = 0;
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
				try {
					dispatcher = request.getRequestDispatcher(GO_TO_PAGE);
					dispatcher.forward(request, response);
				} catch (ServletException | IOException e) {
					logger.error("ServiceAdminImpl: getRegisteredUserByParam: RequestDispatcherError " + e);
				}
			} else {
				response.sendRedirect("controllerServlet?command=cb.admin_page&emptyuser=1");
			}
		} catch (DaoException | IOException e1) {
			logger.error("ServiceAdminImpl: getRegisteredUserByParam: " + e1);
			try {
				response.sendRedirect("controllerServlet?command=cb.admin_page&errorgetting=1");
			} catch (IOException e) {
				logger.error("ServiceAdminImpl: getRegisteredUserByParam: errorSendRedirect" + e);
			}
		}
	}

	@Override
	public void getUnRegisteredUserByParam(final HttpServletRequest request, final HttpServletResponse response) {

		String tableName = null;
		RequestDispatcher dispatcher = null;
		int pageNum = 0;
		int countAllUsers = 0;
		String limitLine = null;
		String offsetLine = null;
		int pageCount = 0;
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
				try {
					dispatcher = request.getRequestDispatcher(GO_TO_PAGE);
					dispatcher.forward(request, response);
				} catch (ServletException | IOException e) {
					logger.error("ServiceAdminImpl: getUnRegisteredUserByParam: RequestDispatcherError " + e);
				}
			} else {
				response.sendRedirect("controllerServlet?command=cb.admin_page&emptyuser=1");
			}
		} catch (DaoException | IOException e1) {
			logger.error("ServiceAdminImpl: getUnRegisteredUserByParam: " + e1);
			try {
				response.sendRedirect("controllerServlet?command=cb.admin_page&errorgetting=1");
			} catch (IOException e) {
				logger.error("ServiceAdminImpl: getUnRegisteredUserByParam: errorSendRedirect" + e);
			}
		}
	}

	@Override
	public void getALLUserByParam(final HttpServletRequest request, final HttpServletResponse response) {

		String tableName = null;
		RequestDispatcher dispatcher = null;
		int pageNum = 0;
		int countAllUsers = 0;
		String limitLine = null;
		String offsetLine = null;
		int pageCount = 0;
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
				try {
					dispatcher = request.getRequestDispatcher(GO_TO_PAGE);
					dispatcher.forward(request, response);
				} catch (ServletException | IOException e) {
					logger.error("ServiceAdminImpl: getUnRegisteredUserByParam: RequestDispatcherError " + e);
				}
			} else {
				response.sendRedirect("controllerServlet?command=cb.admin_page&emptyuser=1");
			}
		} catch (DaoException | IOException e1) {
			logger.error("ServiceAdminImpl: getUnRegisteredUserByParam: " + e1);
			try {
				response.sendRedirect("controllerServlet?command=cb.admin_page&errorgetting=1");
			} catch (IOException e) {
				logger.error("ServiceAdminImpl: getUnRegisteredUserByParam: errorSendRedirect" + e);
			}
		}
	}

	@Override
	public void deleteUser(final HttpServletRequest request, final HttpServletResponse response) {

		String idUser = null;
		idUser = request.getParameter(ServiceParamConstant.USER_ID_PARAM);

		try {
			if (daoAdmin.updateAvaliableFildForUser(Integer.parseInt(idUser), 0)) {
				try {
					response.sendRedirect("controllerServlet?command=cb.admin_page&user_delete_message=1");
				} catch (IOException e) {
					logger.error("ServiceAdminImpl: deleteUser: errorSendRedirect " + e);
				}
			}else {
				response.sendRedirect("controllerServlet?command=cb.admin_page&emptyuser=1");
			}
		} catch (DaoException | IOException e) {
			logger.error("ServiceAdminImpl: deleteUser: " + e);
			try {
				response.sendRedirect("controllerServlet?command=cb.admin_page&errorgetting=1");
			} catch (IOException e1) {
				logger.error("ServiceAdminImpl: deleteUser: errorSendRedirect" + e1);
			}
		}
	}

	@Override
	public void addUser(final HttpServletRequest request, final HttpServletResponse response) {

		String idUser = null;
		RequestDispatcher dispatcher = null;
		idUser = request.getParameter(ServiceParamConstant.USER_ID_PARAM);

		try {
			if (daoAdmin.updateAvaliableFildForUser(Integer.parseInt(idUser), 1)) {
				try {
					request.setAttribute("user_add_message", "1");
					response.sendRedirect("controllerServlet?command=cb.admin_page&user_add_message=1");
				} catch (IOException e) {
					logger.error("ServiceAdminImpl: deleteUser: errorSendRedirect " + e);
				}
			}
		} catch (DaoException e) {
			logger.error("ServiceAdminImpl: deleteUser: DaoException" + e);
			try {
				response.sendRedirect("controllerServlet?command=cb.admin_page&errorgetting=1");
			} catch (IOException e1) {
				logger.error("ServiceAdminImpl: deleteUser: errorSendRedirect" + e1);
			}
		}

	}

	private int countPaging(final int commonCount, final int offsetLine) {
		int result = commonCount % offsetLine > 0 ? Math.floorDiv(commonCount, offsetLine) + 1
				: Math.floorDiv(commonCount, offsetLine);
		return result;
	}

}
