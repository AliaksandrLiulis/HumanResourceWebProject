package by.htp.project.human_resource.service.service_implimentation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.project.human_resource.dao.dao_exception.DaoException;
import by.htp.project.human_resource.dao.dao_factory.DaoFactory;
import by.htp.project.human_resource.dao.dao_interface.IDAOJobSeeker;
import by.htp.project.human_resource.entity.Profile;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.entity.Vacancy;
import by.htp.project.human_resource.service.service_constant.ServiceJspPagePath;
import by.htp.project.human_resource.service.service_constant.ServiceParamConstant;
import by.htp.project.human_resource.service.service_interface.IServiceJobSeeker;

public class ServiceJobSeekerImpl implements IServiceJobSeeker {

	private Logger logger = LoggerFactory.getLogger(ServiceJobSeekerImpl.class);
	private HttpSession session = null;
	private final DaoFactory daoFactory = DaoFactory.getDaoFactory();
	private final IDAOJobSeeker daoJobSeeker = daoFactory.getDaoJodSeeker();
	private final String GO_TO_PAGE = ServiceJspPagePath.PATH_EMPLOYEE_PAGE;

	@Override
	public void addProfile(final HttpServletRequest request, final HttpServletResponse response) {

		String registrationDate = null;
		String birthDayDate = null;
		String phone = null;
		String residence = null;
		String workSpeciality = null;
		String workExpirience = null;
		String education = null;
		String photoPath = null;
		String aboutUser = null;
		String idUser = null;
		User user = null;
		List<Object> objectsList = null;
		Profile profile = null;

		SimpleDateFormat dateFormat = new SimpleDateFormat(ServiceParamConstant.SIMPLE_DATE_FORMATE);
		idUser = request.getParameter(ServiceParamConstant.USER_ID_PARAM);
		registrationDate = dateFormat.format(new Date());
		birthDayDate = request.getParameter(ServiceParamConstant.BIRTHDAY_DATE_PARAM);
		phone = request.getParameter(ServiceParamConstant.PHONE_PARAM);
		residence = request.getParameter(ServiceParamConstant.RESIDENCE_PARAM);
		workSpeciality = request.getParameter(ServiceParamConstant.WORK_SPECIALITY_PARAM);
		workExpirience = request.getParameter(ServiceParamConstant.WORK_EXPIRIENCE_PARAM);
		education = request.getParameter(ServiceParamConstant.EDUCATION_PARAM);
		photoPath = request.getParameter(ServiceParamConstant.PHOTO_PATH_PARAM);
		aboutUser = request.getParameter(ServiceParamConstant.ABOUT_USER_PARAM);
		session = request.getSession();

		try {
			objectsList = daoJobSeeker.addNewProfile(idUser, registrationDate, photoPath, phone, birthDayDate,
					residence, workSpeciality, workExpirience, education, aboutUser);
			if (objectsList != null) {
				if (objectsList.get(0) instanceof User) {
					user = (User) objectsList.get(0);
					session.removeAttribute(ServiceParamConstant.USER_ATTRIBUTE);
					session.setAttribute(ServiceParamConstant.USER_ATTRIBUTE, user);
				}
				if (objectsList.get(1) instanceof Profile) {
					profile = (Profile) objectsList.get(1);
					session.setAttribute(ServiceParamConstant.PROFILE_ATTRIBUTE, profile);

				}
				try {
					response.sendRedirect("controllerServlet?command=cb.employee_page&profile_add_message=1");
				} catch (IOException e) {
					logger.error("ServiceJobSeekerImpl: addProfile: SendRedirectError " + e);
				}
			} else {
				try {
					response.sendRedirect("controllerServlet?command=cb.employee_page&profile_add_message=0");
				} catch (IOException e) {
					logger.error("ServiceJobSeekerImpl: addProfile: SendRedirectError " + e);
				}
			}
		} catch (DaoException e) {
			logger.error("ServiceJobSeekerImpl: addProfile: daoException" + e);
			try {
				response.sendRedirect("controllerServlet?command=cb.employee_page&profile_add_message=0");
			} catch (IOException e1) {
				logger.error("ServiceJobSeekerImpl: addProfile: SendRedirectError " + e1);
			}
		}
	}

	@Override
	public void deleteProfile(final HttpServletRequest request, final HttpServletResponse response) {

		String idUser = null;
		User user = null;

		idUser = request.getParameter(ServiceParamConstant.USER_ID_PARAM);
		session = request.getSession();

		try {
			user = daoJobSeeker.removeProfileByUserId(Integer.parseInt(idUser));
			if (user != null) {
				session.removeAttribute(ServiceParamConstant.USER_ATTRIBUTE);
				session.setAttribute(ServiceParamConstant.USER_ATTRIBUTE, user);
				session.removeAttribute(ServiceParamConstant.PROFILE_ATTRIBUTE);
				try {
					response.sendRedirect("controllerServlet?command=cb.employee_page&profile_delete_message=1");
				} catch (IOException e) {
					logger.error("ServiceJobSeekerImpl: deleteProfile: SendRedirectError " + e);
				}
			} else {
				try {
					response.sendRedirect("controllerServlet?command=cb.employee_page&profile_delete_message=0");
				} catch (IOException e) {
					logger.error("ServiceJobSeekerImpl: deleteProfile: SendRedirectError " + e);
				}
			}
		} catch (DaoException e1) {
			logger.error("ServiceJobSeekerImpl: deleteProfile: daoException" + e1);
			try {
				response.sendRedirect("controllerServlet?command=cb.employee_page&profile_delete_message=0");
			} catch (IOException e) {
				logger.error("ServiceJobSeekerImpl: addProfile: SendRedirectError " + e1);
			}
		}
	}

	@Override
	public void updateProfile(final HttpServletRequest request, final HttpServletResponse response) {

		String registrationDate = null;
		String birthDayDate = null;
		String phone = null;
		String residence = null;
		String workSpeciality = null;
		String workExpirience = null;
		String education = null;
		String photoPath = null;
		String aboutUser = null;
		String idUser = null;
		Profile profile = null;

		SimpleDateFormat dateFormat = new SimpleDateFormat(ServiceParamConstant.SIMPLE_DATE_FORMATE);
		idUser = request.getParameter(ServiceParamConstant.USER_ID_PARAM);
		registrationDate = dateFormat.format(new Date());
		birthDayDate = request.getParameter(ServiceParamConstant.BIRTHDAY_DATE_PARAM);
		phone = request.getParameter(ServiceParamConstant.PHONE_PARAM);
		residence = request.getParameter(ServiceParamConstant.RESIDENCE_PARAM);
		workSpeciality = request.getParameter(ServiceParamConstant.WORK_SPECIALITY_PARAM);
		workExpirience = request.getParameter(ServiceParamConstant.WORK_EXPIRIENCE_PARAM);
		education = request.getParameter(ServiceParamConstant.EDUCATION_PARAM);
		photoPath = request.getParameter(ServiceParamConstant.PHOTO_PATH_PARAM);
		aboutUser = request.getParameter(ServiceParamConstant.ABOUT_USER_PARAM);
		session = request.getSession();

		try {
			profile = daoJobSeeker.updateOldProfileByParams(idUser, registrationDate, photoPath, phone, birthDayDate,
					residence, workSpeciality, workExpirience, education, aboutUser);
			if (profile != null) {
				session.removeAttribute(ServiceParamConstant.PROFILE_ATTRIBUTE);
				session.setAttribute(ServiceParamConstant.PROFILE_ATTRIBUTE, profile);
				try {
					response.sendRedirect("controllerServlet?command=cb.employee_page&profile_update_message=1");
				} catch (IOException e) {
					logger.error("ServiceJobSeekerImpl: updateProfile: SendRedirectError " + e);
				}
			} else {
				try {
					response.sendRedirect("controllerServlet?command=cb.employee_page&profile_update_message=0");
				} catch (IOException e) {
					logger.error("ServiceJobSeekerImpl: updateProfile: SendRedirectError " + e);
				}
			}
		} catch (DaoException e1) {
			logger.error("ServiceJobSeekerImpl: updateProfile:daoException " + e1);
			try {
				response.sendRedirect("controllerServlet?command=cb.employee_page&profile_update_message=0");
			} catch (IOException e) {
				logger.error("ServiceJobSeekerImpl: updateProfile: SendRedirectError " + e1);
			}
		}
	}

	@Override
	public void addResume(final HttpServletRequest request, final HttpServletResponse response) {

		String name = null;
		String surName = null;
		String email = null;
		String registrationDate = null;
		String birthDayDate = null;
		String phone = null;
		String residence = null;
		String workSpeciality = null;
		String workExpirience = null;
		String education = null;
		String photoPath = null;
		String aboutUser = null;
		String idUser = null;
		User user = null;

		name = request.getParameter(ServiceParamConstant.NAME_PARAM);
		surName = request.getParameter(ServiceParamConstant.SURNAME_PARAM);
		email = request.getParameter(ServiceParamConstant.EMAIL_PARAM);
		registrationDate = request.getParameter(ServiceParamConstant.REGISTRATION_DATE_PARAM);
		birthDayDate = request.getParameter(ServiceParamConstant.BIRTHDAY_DATE_PARAM);
		phone = request.getParameter(ServiceParamConstant.PHONE_PARAM);
		residence = request.getParameter(ServiceParamConstant.RESIDENCE_PARAM);
		workSpeciality = request.getParameter(ServiceParamConstant.WORK_SPECIALITY_PARAM);
		workExpirience = request.getParameter(ServiceParamConstant.WORK_EXPIRIENCE_PARAM);
		education = request.getParameter(ServiceParamConstant.EDUCATION_PARAM);
		photoPath = request.getParameter(ServiceParamConstant.PHOTO_PATH_PARAM);
		aboutUser = request.getParameter(ServiceParamConstant.ABOUT_USER_PARAM);
		idUser = request.getParameter(ServiceParamConstant.USER_ID_PARAM);
		session = request.getSession();

		try {
			user = daoJobSeeker.addNewResumeByParams(name, surName, email, registrationDate, birthDayDate, phone,
					residence, workSpeciality, workExpirience, education, photoPath, aboutUser, idUser);
			if (user != null) {
				session.removeAttribute(ServiceParamConstant.USER_ATTRIBUTE);
				session.setAttribute(ServiceParamConstant.USER_ATTRIBUTE, user);
				try {
					response.sendRedirect("controllerServlet?command=cb.employee_page&resume_add_message=1");
				} catch (IOException e) {
					logger.error("ServiceJobSeekerImpl: addResume: SendRedirectError " + e);
				}
			} else {
				try {
					response.sendRedirect("controllerServlet?command=cb.employee_page&resume_add_message=0");
				} catch (IOException e) {
					logger.error("ServiceJobSeekerImpl: addResume: SendRedirectError " + e);
				}
			}
		} catch (DaoException e) {
			logger.error("ServiceJobSeekerImpl: addResume:daoException " + e);
			try {
				response.sendRedirect("controllerServlet?command=cb.employee_page&resume_add_message=0");
			} catch (IOException e1) {
				logger.error("ServiceJobSeekerImpl: addResume: SendRedirectError " + e1);
			}

		}
	}

	@Override
	public void deleteResume(final HttpServletRequest request, final HttpServletResponse response) {

		String resumeId = null;
		User user = null;

		session = request.getSession();
		resumeId = request.getParameter(ServiceParamConstant.USER_RESUME_ID__PARAM);
		try {
			user = daoJobSeeker.deleteResumeByIdUser(Integer.parseInt(resumeId));
			if (user != null) {
				session.removeAttribute(ServiceParamConstant.USER_ATTRIBUTE);
				session.setAttribute(ServiceParamConstant.USER_ATTRIBUTE, user);
				try {
					response.sendRedirect("controllerServlet?command=cb.employee_page&resume_delete_message=1");
				} catch (IOException e) {
					logger.error("ServiceJobSeekerImpl: addResume: SendRedirectError " + e);
				}
			} else {
				try {
					response.sendRedirect("controllerServlet?command=cb.employee_page&resume_delete_message=0");
				} catch (IOException e) {
					logger.error("ServiceJobSeekerImpl: addResume: SendRedirectError " + e);
				}
			}
		} catch (DaoException e) {
			logger.error("ServiceJobSeekerImpl: deleteResume: addResume:daoException " + e);
			try {
				response.sendRedirect("controllerServlet?command=cb.employee_page&resume_delete_message=0");
			} catch (IOException e1) {
				logger.error("ServiceJobSeekerImpl: addResume: SendRedirectError " + e1);
			}

		}
	}

	@Override
	public void getVacancy(final HttpServletRequest request, final HttpServletResponse response) {

		int pageNum = 0;
		String tableNameVacancy;
		int countAllVacancies = 0;
		String limitLine = null;
		String offsetLine = null;
		int pageCount = 0;
		int userId = 0;
		List<Vacancy> allVacancy;
		List<String> allRespondVacancyId;
		RequestDispatcher dispatcher = null;

		tableNameVacancy = ServiceParamConstant.VACANCIES_TABLE_NAME_PARAM;
		limitLine = request.getParameter(ServiceParamConstant.Limit_LINE_NUMBER);
		offsetLine = request.getParameter(ServiceParamConstant.OFFSET_LINE_NUMBER);
		pageNum = Integer.parseInt(request.getParameter(ServiceParamConstant.PAGE_NUM));
		userId = Integer.parseInt(request.getParameter(ServiceParamConstant.USER_ID_PARAM));
		try {
			countAllVacancies = daoJobSeeker.getCountAllRowsForTable(tableNameVacancy);
			if (countAllVacancies != 0) {
				allVacancy = daoJobSeeker.searchVacancyByParam(limitLine, offsetLine);
				if (allVacancy != null) {
					allRespondVacancyId = daoJobSeeker.searchRespondVacancyByUserId(userId);
					if (allRespondVacancyId != null) {
						request.setAttribute("allRespondVacancy", allRespondVacancyId);
						pageCount = countPaging(countAllVacancies, Integer.parseInt(limitLine));
						request.setAttribute(ServiceParamConstant.PAGE_NUM, pageNum);
						request.setAttribute(ServiceParamConstant.PAGE_COUNT, pageCount);
						request.setAttribute(ServiceParamConstant.ALL_VACANCY_ATTRIBUTE, allVacancy);
					}
				} else {
					request.setAttribute("messageaboutvacancy", "message_about_empty_list_vacancy");
					request.setAttribute("no_vacancies", "message_about_empty_list_vacancy");
				}
			} else {
				request.setAttribute("messageaboutvacancy", "message_about_empty_list_vacancy");
				request.setAttribute("no_vacancies", "message_about_empty_list_vacancy");
			}
		} catch (DaoException e) {
			logger.error("ServiceJobSeekerImpl: getVacancy: " + e);
			request.setAttribute("messageaboutvacancy", "vacancy receipt error");
			request.setAttribute("error_get_vacancy", "vacancy receipt error");
		} finally {
			try {
				dispatcher = request.getRequestDispatcher(GO_TO_PAGE);
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				logger.error("ServiceJobSeekerImpl: getVacancy: " + e);
			}
		}
	}

	@Override
	public void respondOnvacancy(final HttpServletRequest request, final HttpServletResponse response) {

		String userId = null;
		String vacancyId = null;
		boolean result = false;

		userId = request.getParameter(ServiceParamConstant.USER_ID_PARAM);
		vacancyId = request.getParameter(ServiceParamConstant.VACANCY_ID_PARAM);
		try {
			result = daoJobSeeker.updateVacancyWhenRespondAndAddInTable(Integer.parseInt(userId),
					Integer.parseInt(vacancyId));
			if (result) {
				try {
					response.sendRedirect("controllerServlet?command=cb.employee_page&respond=ok&respondadded=yes");
				} catch (IOException e) {
					logger.error("ServiceJobSeekerImpl: respondOnvacancy:sendRedirectError " + e);
				}
			} else {
				try {
					response.sendRedirect("controllerServlet?command=cb.employee_page&respond=ok");
				} catch (IOException e1) {
					logger.error("ServiceJobSeekerImpl: respondOnvacancy :sendRedirectError " + e1);
				}
			}
		} catch (DaoException e) {
			try {
				response.sendRedirect("controllerServlet?command=cb.employee_page&respond=ok");
				logger.error("ServiceJobSeekerImpl: daoException: " + e);
			} catch (IOException e1) {
				logger.error("ServiceJobSeekerImpl: respondOnvacancy:sendRedirectError " + e1);
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void deleteRespondOnVacancy(final HttpServletRequest request, final HttpServletResponse response) {
		String userId = null;
		String vacancyId = null;
		boolean result = false;

		userId = request.getParameter(ServiceParamConstant.USER_ID_PARAM);
		vacancyId = request.getParameter(ServiceParamConstant.VACANCY_ID_PARAM);
		try {
			result = daoJobSeeker.updateVacancyWhenRespondAndDeleteInTable(Integer.parseInt(userId),
					Integer.parseInt(vacancyId));
			if (result) {
				try {
					response.sendRedirect("controllerServlet?command=cb.employee_page&respond=ok&respondadded=yes");
				} catch (IOException e) {
					logger.error("ServiceJobSeekerImpl: deleteRespondOnVacancy:sendRedirectError " + e);
				}
			} else {
				try {
					response.sendRedirect("controllerServlet?command=cb.employee_page&respond=ok");
				} catch (IOException e1) {
					logger.error("ServiceJobSeekerImpl: deleteRespondOnVacancy :sendRedirectError " + e1);
				}
			}
		} catch (DaoException e) {
			try {
				response.sendRedirect("controllerServlet?command=cb.employee_page&respond=ok");
				logger.error("ServiceJobSeekerImpl: daoException: " + e);
			} catch (IOException e1) {
				logger.error("ServiceJobSeekerImpl: deleteRespondOnVacancy:sendRedirectError " + e1);
				e1.printStackTrace();
			}
		}
	}

	private int countPaging(final int commonCount, final int offsetLine) {
		int result = commonCount % offsetLine > 0 ? Math.floorDiv(commonCount, offsetLine) + 1
				: Math.floorDiv(commonCount, offsetLine);
		return result;
	}
}
