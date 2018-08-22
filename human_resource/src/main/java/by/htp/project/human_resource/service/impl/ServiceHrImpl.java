package by.htp.project.human_resource.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.project.human_resource.dao.exception.DaoException;
import by.htp.project.human_resource.dao.factory.DaoFactory;
import by.htp.project.human_resource.dao.interf.IDaoHr;
import by.htp.project.human_resource.entity.Vacancy;
import by.htp.project.human_resource.service.constant.ServiceJspPagePath;
import by.htp.project.human_resource.service.constant.ServiceParamConstant;
import by.htp.project.human_resource.service.interf.IServiceHr;

public class ServiceHrImpl implements IServiceHr {

	Logger logger = LoggerFactory.getLogger(ServiceHrImpl.class);
	private HttpSession session = null;
	private final DaoFactory daoFactory = DaoFactory.getDaoFactory();
	private final IDaoHr daoHr = daoFactory.getDaoHr();
	private final String GO_TO_PAGE = ServiceJspPagePath.PATH_HR_PAGE;

	@Override
	public void addVacancy(final HttpServletRequest request, final HttpServletResponse response) {

		Vacancy vacancy = null;
		List<String> paramsList = null;
		RequestDispatcher dispatcher = null;
		try {
			if (request.getParameter(ServiceParamConstant.PROFESSION_PARAM).equals(ServiceParamConstant.DRIVER_NAME)) {
				paramsList = addDriverVacancy(request);
				try {
					vacancy = daoHr.addDriverVacancy(paramsList);
				} catch (DaoException e) {
					logger.error("ServiceHrImpl: addVacancyDriver: " + e);
					request.setAttribute("vacancy_add_message", "0");
				}
			}
			if (request.getParameter(ServiceParamConstant.PROFESSION_PARAM)
					.equals(ServiceParamConstant.ACCOUNTANT_NAME)) {
				paramsList = addAccountantVacancy(request);
				try {
					vacancy = daoHr.addAccountantVacancy(paramsList);
				} catch (DaoException e) {
					logger.error("ServiceHrImpl: addVacancyAccountant: " + e);
					request.setAttribute("vacancy_add_message", "0");
				}
			}
			if (vacancy != null) {
				request.setAttribute(ServiceParamConstant.VACANCY_ATTRIBUTE, vacancy);
				request.setAttribute("vacancy_add_message", "1");
				
			} else {
				request.setAttribute("vacancy_add_message", "0");
			}
		} finally {
			try {
				dispatcher = request.getRequestDispatcher(GO_TO_PAGE);
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				logger.error("ServiceHrImpl: addVacancy: " + e);
			}
		}
	}

	@Override
	public void getVacancy(HttpServletRequest request, HttpServletResponse response) {
		int pageNum = 0;
		String tableNameVacancy;
		int countAllVacancies = 0;
		String whoAddedId = null;
		String limitLine = null;
		String offsetLine = null;
		int pageCount = 0;
		List<Vacancy> allVacancy;
		RequestDispatcher dispatcher = null;

		tableNameVacancy = request.getParameter(ServiceParamConstant.VACANCY_ATTRIBUTE);
		limitLine = request.getParameter(ServiceParamConstant.Limit_LINE_NUMBER);
		offsetLine = request.getParameter(ServiceParamConstant.OFFSET_LINE_NUMBER);
		whoAddedId = request.getParameter(ServiceParamConstant.USER_ID_PARAM);
		pageNum = Integer.parseInt(request.getParameter(ServiceParamConstant.PAGE_NUM));
		try {
			countAllVacancies = daoHr.getCountAllRowsForTable(tableNameVacancy);
			if (countAllVacancies != 0) {
				allVacancy = daoHr.searchVacancyByParam(tableNameVacancy, limitLine, offsetLine, whoAddedId);
				if (allVacancy != null) {
					pageCount = countPaging(countAllVacancies, Integer.parseInt(limitLine));
					request.setAttribute(ServiceParamConstant.PAGE_NUM, pageNum);
					request.setAttribute(ServiceParamConstant.PAGE_COUNT, pageCount);
					request.setAttribute(ServiceParamConstant.ALL_VACANCY_ATTRIBUTE, allVacancy);

				} else {
					request.setAttribute("no_vacancies", "message_about_empty_list_vacancy");
				}
			} else {
				request.setAttribute("no_vacancies", "message_about_empty_list_vacancy");
			}
		} catch (DaoException e) {
			logger.error("ServiceHrImpl: getVacancy: " + e);
			request.setAttribute("error_get_vacancy", "vacancy receipt error");
		} finally {
			try {
				dispatcher = request.getRequestDispatcher(GO_TO_PAGE);
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				logger.error("ServiceHrImpl: getVacancy: " + e);
			}
		}
	}
	
	@Override
	public void getResume(HttpServletRequest request, HttpServletResponse response) {
		String tableNameVacancy = null;
		int pageNum = 0;		
		int countAllResume = 0;
		String limitLine = null;
		String offsetLine = null;
		int pageCount = 0;
		List<String> allResume;
		RequestDispatcher dispatcher = null;

		tableNameVacancy = ServiceParamConstant.RESUME_ATTRIBUTE;
		limitLine = request.getParameter(ServiceParamConstant.Limit_LINE_NUMBER);
		offsetLine = request.getParameter(ServiceParamConstant.OFFSET_LINE_NUMBER);
		pageNum = Integer.parseInt(request.getParameter(ServiceParamConstant.PAGE_NUM));
		try {
						
			countAllResume = daoHr.getCountAllRowsForTable(tableNameVacancy);
			if (countAllResume != 0) {
				allResume = daoHr.searchResumeByParam(limitLine, offsetLine);
				if (allResume != null) {
					pageCount = countPaging(countAllResume, Integer.parseInt(limitLine));
					request.setAttribute(ServiceParamConstant.PAGE_NUM, pageNum);
					request.setAttribute(ServiceParamConstant.PAGE_COUNT, pageCount);
					request.setAttribute(ServiceParamConstant.ALL_VACANCY_ATTRIBUTE, allResume);

				} else {
					request.setAttribute("no_resume", "message_about_empty_list_resume");
				}
			} else {
				request.setAttribute("no_resume", "message_about_empty_list_resume");
			}
		} catch (DaoException e) {
			logger.error("ServiceHrImpl: getVacancy: " + e);
			request.setAttribute("error_get_resume", "resume receipt error");
		} finally {
			try {
				dispatcher = request.getRequestDispatcher(GO_TO_PAGE);
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				logger.error("ServiceHrImpl: getResume: " + e);
			}
		}
	}

	@Override
	public void deleteVacancyById(HttpServletRequest request, HttpServletResponse response) {
		String idVacancy = null;
		RequestDispatcher dispatcher = null;

		idVacancy = request.getParameter(ServiceParamConstant.VACANCY_ID_PARAM);

		try {
			if (daoHr.deleteVacancy(Integer.parseInt(idVacancy))) {
				request.setAttribute("vacancy_delete_message", "1");
			} else {
				request.setAttribute("vacancy_delete_message", "0");
			}
		} catch (NumberFormatException | DaoException e) {
			logger.error("ServiceHrImpl: deleteVacancyById: " + e);
			request.setAttribute("vacancy_delete_message", "0");
		} finally {
			try {
				dispatcher = request.getRequestDispatcher(GO_TO_PAGE);
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				logger.error("ServiceHrImpl: deleteVacancyById: " + e);
			}
		}

	}

	private List<String> addDriverVacancy(final HttpServletRequest request) {
		String companyName = null;
		String goods = null;
		String experience = null;
		String dlCategory = null;
		String salary = null;
		String whoAdded = null;
		String profession = ServiceParamConstant.DRIVER_NAME;
		List<String> paramsList = new ArrayList<>();

		companyName = request.getParameter(ServiceParamConstant.COMPANY_NAME_PARAM);
		goods = request.getParameter(ServiceParamConstant.GOODS_NAME_PARAM);
		experience = request.getParameter(ServiceParamConstant.WORK_EXPIRIENCE_PARAM);
		dlCategory = request.getParameter(ServiceParamConstant.DRIVER_LICENC_CATEGORY_PARAM);
		salary = request.getParameter(ServiceParamConstant.SALARY_PARAM);
		whoAdded = request.getParameter(ServiceParamConstant.USER_ID_PARAM);

		paramsList.add(profession);
		paramsList.add(companyName);
		paramsList.add(experience);
		paramsList.add(salary);
		paramsList.add(goods);
		paramsList.add(dlCategory);
		paramsList.add(whoAdded);

		return paramsList;
	}

	private List<String> addAccountantVacancy(final HttpServletRequest request) {
		String companyName = null;
		String experience = null;
		String salary = null;
		String whoAdded = null;
		String profession = ServiceParamConstant.ACCOUNTANT_NAME;
		List<String> paramsList = new ArrayList<>();

		companyName = request.getParameter(ServiceParamConstant.COMPANY_NAME_PARAM);
		experience = request.getParameter(ServiceParamConstant.WORK_EXPIRIENCE_PARAM);
		salary = request.getParameter(ServiceParamConstant.SALARY_PARAM);
		whoAdded = request.getParameter(ServiceParamConstant.USER_ID_PARAM);

		paramsList.add(profession);
		paramsList.add(companyName);
		paramsList.add(experience);
		paramsList.add(salary);
		paramsList.add(whoAdded);

		return paramsList;
	}

	private int countPaging(final int commonCount, final int offsetLine) {
		int result = commonCount % offsetLine > 0 ? Math.floorDiv(commonCount, offsetLine) + 1
				: Math.floorDiv(commonCount, offsetLine);
		return result;
	}

}
