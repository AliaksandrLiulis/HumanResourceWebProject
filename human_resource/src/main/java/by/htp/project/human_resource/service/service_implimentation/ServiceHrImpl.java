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
import by.htp.project.human_resource.dao.dao_interface.IDaoHr;
import by.htp.project.human_resource.entity.Resume;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.entity.Vacancy;
import by.htp.project.human_resource.service.service_constant.ServiceJspPagePath;
import by.htp.project.human_resource.service.service_constant.ServiceParamConstant;
import by.htp.project.human_resource.service.service_interface.IServiceHr;

/**
 * Class which has methods for work with Users which have role Hr
 */

public class ServiceHrImpl implements IServiceHr {

	/** Field for logging {@link LoggerFactory} */
	private static final Logger logger = LoggerFactory.getLogger(ServiceHrImpl.class);
	/** Field for daoFactory */
	private final DaoFactory daoFactory = DaoFactory.getDaoFactory();
	/** Field for daoHr implementation */
	private final IDaoHr daoHr = daoFactory.getDaoHr();

	@Override
	public void addVacancy(final HttpServletRequest request, final HttpServletResponse response) throws IOException {

		Vacancy vacancy = null;
		List<String> paramsList = null;
		String goToPage = null;

		if (request.getParameter(ServiceParamConstant.PROFESSION_PARAM).equals(ServiceParamConstant.DRIVER_NAME)) {
			paramsList = addDriverVacancy(request);
			try {
				vacancy = daoHr.addDriverVacancy(paramsList);
			} catch (DaoException e) {
				logger.error("ServiceHrImpl: addVacancyDriver: daoExceptionError", e);
				goToPage = "controllerServlet?command=cb.hr_page&vacancy_add_message=1";
			}
		}
		if (request.getParameter(ServiceParamConstant.PROFESSION_PARAM).equals(ServiceParamConstant.ACCOUNTANT_NAME)) {
			paramsList = addAccountantVacancy(request);
			try {
				vacancy = daoHr.addAccountantVacancy(paramsList);
			} catch (DaoException e) {
				logger.error("ServiceHrImpl: addVacancyDriver: daoExceptionError", e);
				goToPage = "controllerServlet?command=cb.hr_page&vacancy_add_message=1";
			}
		}
		if (vacancy != null) {
			goToPage = "controllerServlet?command=cb.hr_page&vacancy_add_message=1&vacancy_added=yes";
		} else {
			goToPage = "controllerServlet?command=cb.hr_page&vacancy_add_message=1";
		}
		try {
			response.sendRedirect(goToPage);
		} catch (IOException e) {
			logger.error("ServiceHrImpl: addVacancy: SendRedirectError ", e);
			throw e;
		}

	}

	@Override
	public void getVacancy(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		int pageNum = 0;
		String tableNameVacancy;
		int countAllVacancies = 0;
		String whoAddedId = null;
		String limitLine = null;
		String offsetLine = null;
		String goToPage = null;
		int pageCount = 0;
		List<Vacancy> allVacancy;
		RequestDispatcher dispatcher = null;

		List<String> allRespondedId = new ArrayList<>();
		tableNameVacancy = request.getParameter(ServiceParamConstant.VACANCY_ATTRIBUTE);
		limitLine = request.getParameter(ServiceParamConstant.Limit_LINE_NUMBER);
		offsetLine = request.getParameter(ServiceParamConstant.OFFSET_LINE_NUMBER);
		whoAddedId = request.getParameter(ServiceParamConstant.USER_ID_PARAM);
		pageNum = Integer.parseInt(request.getParameter(ServiceParamConstant.PAGE_NUM));

		try {

			countAllVacancies = daoHr.getCountAllRowsForTable(tableNameVacancy, Integer.parseInt(whoAddedId));

			if (countAllVacancies != 0) {
				allVacancy = daoHr.searchVacancyByParam(tableNameVacancy, limitLine, offsetLine, whoAddedId);
				if (allVacancy != null) {
					allRespondedId = daoHr.searchRespondedOnVacancy();
					pageCount = countPaging(countAllVacancies, Integer.parseInt(limitLine));
					request.setAttribute(ServiceParamConstant.PAGE_NUM, pageNum);
					request.setAttribute(ServiceParamConstant.PAGE_COUNT, pageCount);
					request.setAttribute(ServiceParamConstant.ALL_VACANCY_ATTRIBUTE, allVacancy);
					request.setAttribute("allRespondedId", allRespondedId);
				} else {
					request.setAttribute("messageaboutvacancy", "message_about_empty_list_vacancy");
					request.setAttribute("no_vacancies", "message_about_empty_list_vacancy");
				}
			} else {
				request.setAttribute("messageaboutvacancy", "message_about_empty_list_vacancy");
				request.setAttribute("no_vacancies", "message_about_empty_list_vacancy");
			}
		} catch (DaoException e) {
			logger.error("ServiceHrImpl: getVacancy: daoExceptionError ", e);
			request.setAttribute("messageaboutvacancy", "vacancy receipt error");
			request.setAttribute("error_get_vacancy", "vacancy receipt error");
		}
		try {
			goToPage = ServiceJspPagePath.PATH_HR_PAGE;
			dispatcher = request.getRequestDispatcher(goToPage);
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			logger.error("ServiceHrImpl: getVacancy: RequestDispatherError ", e);
			throw e;
		}
	}

	@Override
	public void getResume(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		String tableNameVacancy = null;
		int pageNum = 0;
		int countAllResume = 0;
		String limitLine = null;
		String offsetLine = null;
		String goToPage = null;
		int pageCount = 0;
		List<Resume> allResume;
		RequestDispatcher dispatcher = null;

		tableNameVacancy = ServiceParamConstant.RESUME_ATTRIBUTE;
		limitLine = request.getParameter(ServiceParamConstant.Limit_LINE_NUMBER);
		offsetLine = request.getParameter(ServiceParamConstant.OFFSET_LINE_NUMBER);
		pageNum = Integer.parseInt(request.getParameter(ServiceParamConstant.PAGE_NUM));

		try {
			countAllResume = daoHr.getCountAllRowsForTable(tableNameVacancy, 0);
			if (countAllResume != 0) {
				allResume = daoHr.searchResumeByParam(limitLine, offsetLine);
				if (allResume != null) {
					pageCount = countPaging(countAllResume, Integer.parseInt(limitLine));
					request.setAttribute(ServiceParamConstant.PAGE_NUM, pageNum);
					request.setAttribute(ServiceParamConstant.PAGE_COUNT, pageCount);
					request.setAttribute(ServiceParamConstant.ALL_RESUME_ATTRIBUTE, allResume);
				} else {
					request.setAttribute("messageaboutresume", "message_about_empty_list_resume");
					request.setAttribute("no_resume", "message_about_empty_list_resume");
				}
			} else {
				request.setAttribute("messageaboutresume", "message_about_empty_list_resume");
				request.setAttribute("no_resume", "message_about_empty_list_resume");
			}
		} catch (DaoException e) {
			logger.error("ServiceHrImpl: getVacancy: ", e);
			request.setAttribute("messageaboutresume", "resume receipt error");
			request.setAttribute("error_get_resume", "resume receipt error");
		}
		try {
			goToPage = ServiceJspPagePath.PATH_HR_PAGE;
			dispatcher = request.getRequestDispatcher(goToPage);
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			logger.error("ServiceHrImpl: getResume: RequestDispatherError ", e);
			throw e;
		}
	}

	@Override
	public void deleteVacancyById(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		String idVacancy = null;
		String goToPage = null;
		RequestDispatcher dispatcher = null;

		idVacancy = request.getParameter(ServiceParamConstant.VACANCY_ID_PARAM);

		try {
			if (daoHr.deleteVacancyById(Integer.parseInt(idVacancy))) {
				request.setAttribute("vacancy_delete_message", "1");
			} else {
				request.setAttribute("vacancy_delete_message", "0");
			}
		} catch (DaoException e) {
			logger.error("ServiceHrImpl: deleteVacancyById: " + e);
			request.setAttribute("vacancy_delete_message", "0");
		}
		try {
			goToPage = ServiceJspPagePath.PATH_HR_PAGE;
			dispatcher = request.getRequestDispatcher(goToPage);
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			logger.error("ServiceHrImpl: deleteVacancyById: RequestDispatcherError", e);
			throw e;
		}
	}

	@Override
	public void getAllVacancyResponded(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		String vacancyId = null;
		String goToPage = null;
		List<User> allUsersWhoRespond = null;
		RequestDispatcher dispatcher = null;

		vacancyId = request.getParameter(ServiceParamConstant.VACANCY_ID_PARAM);

		try {
			allUsersWhoRespond = daoHr.searchRespondedUserByIdVacancy(Integer.parseInt(vacancyId));
			if (allUsersWhoRespond != null) {
				request.setAttribute("allUsersWhoRespond", allUsersWhoRespond);
			}
		} catch (DaoException e) {
			logger.error("ServiceHrImpl: getAllVacancyResponded: ", e);
		}
		try {
			goToPage = ServiceJspPagePath.PATH_HR_PAGE;
			dispatcher = request.getRequestDispatcher(goToPage);
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			logger.error("ServiceHrImpl: getAllVacancyResponded: RequestDispatcherError ", e);
			throw e;
		}
	}

	/**
	 * method for create driver {@link Vacancy}
	 * 
	 * @param request is HTTPRequest
	 * @return {@link List} {@link String}
	 */
	private List<String> addDriverVacancy(final HttpServletRequest request) {

		String companyName = null;
		String goods = null;
		String experience = null;
		String dlCategory = null;
		String salary = null;
		String whoAdded = null;
		String professionByLocal = null;
		List<String> paramsList = new ArrayList<>();

		companyName = request.getParameter(ServiceParamConstant.COMPANY_NAME_PARAM);
		goods = request.getParameter(ServiceParamConstant.GOODS_NAME_PARAM);
		experience = request.getParameter(ServiceParamConstant.WORK_EXPIRIENCE_PARAM);
		dlCategory = request.getParameter(ServiceParamConstant.DRIVER_LICENC_CATEGORY_PARAM);
		salary = request.getParameter(ServiceParamConstant.SALARY_PARAM);
		whoAdded = request.getParameter(ServiceParamConstant.USER_ID_PARAM);
		professionByLocal = request.getParameter(ServiceParamConstant.PROFESSION_NAME_BY_LOCAL);

		paramsList.add(professionByLocal);
		paramsList.add(companyName);
		paramsList.add(experience);
		paramsList.add(salary);
		paramsList.add(goods);
		paramsList.add(dlCategory);
		paramsList.add(whoAdded);

		return paramsList;
	}

	/**
	 * method for create accountant {@link Vacancy}
	 * 
	 * @param request is HTTPRequest
	 * @return {@link List} {@link String}
	 */
	private List<String> addAccountantVacancy(final HttpServletRequest request) {

		String companyName = null;
		String experience = null;
		String salary = null;
		String whoAdded = null;
		String professionByLocal = null;
		List<String> paramsList = new ArrayList<>();

		companyName = request.getParameter(ServiceParamConstant.COMPANY_NAME_PARAM);
		experience = request.getParameter(ServiceParamConstant.WORK_EXPIRIENCE_PARAM);
		salary = request.getParameter(ServiceParamConstant.SALARY_PARAM);
		whoAdded = request.getParameter(ServiceParamConstant.USER_ID_PARAM);
		professionByLocal = request.getParameter(ServiceParamConstant.PROFESSION_NAME_BY_LOCAL);

		paramsList.add(professionByLocal);
		paramsList.add(companyName);
		paramsList.add(experience);
		paramsList.add(salary);
		paramsList.add(whoAdded);

		return paramsList;
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
