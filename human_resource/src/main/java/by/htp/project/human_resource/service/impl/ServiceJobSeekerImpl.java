package by.htp.project.human_resource.service.impl;

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

import by.htp.project.human_resource.dao.exception.DaoException;
import by.htp.project.human_resource.dao.factory.DaoFactory;
import by.htp.project.human_resource.dao.interf.IDAOJobSeeker;
import by.htp.project.human_resource.entity.Profile;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.service.constant.ServiceJspPagePath;
import by.htp.project.human_resource.service.constant.ServiceParamConstant;
import by.htp.project.human_resource.service.interf.IServiceJobSeeker;

public class ServiceJobSeekerImpl implements IServiceJobSeeker {

	Logger logger = LoggerFactory.getLogger(ServiceJobSeekerImpl.class);
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
		RequestDispatcher dispatcher = null;

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
					request.setAttribute("profile_add_message", "1");
				}
			} else {
				request.setAttribute("profile_add_message", "0");
			}
		} catch (DaoException e1) {
			logger.error("ServiceJobSeekerImpl: addProfile: " + e1);
			request.setAttribute("profile_add_message", "0");
		}finally {
			try {
				dispatcher = request.getRequestDispatcher(GO_TO_PAGE);
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				logger.error("ServiceJobSeekerImpl: addProfile: " + e);
			}
		}		
	}

	@Override
	public void deleteProfile(final HttpServletRequest request, final HttpServletResponse response) {

		String idUser = null;
		User user = null;
		RequestDispatcher dispatcher = null;

		idUser = request.getParameter(ServiceParamConstant.USER_ID_PARAM);
		session = request.getSession();
		try {
			user = daoJobSeeker.removeProfile(Integer.parseInt(idUser));
			if (user != null) {
				request.setAttribute("profile_delete_message", "1");
				session.removeAttribute(ServiceParamConstant.USER_ATTRIBUTE);
				session.setAttribute(ServiceParamConstant.USER_ATTRIBUTE, user);
				session.removeAttribute(ServiceParamConstant.PROFILE_ATTRIBUTE);
			} else {
				request.setAttribute("profile_delete_message", "0");
			}
		} catch (NumberFormatException | DaoException e1) {
			logger.error("ServiceJobSeekerImpl: deleteProfile: " + e1);
			request.setAttribute("profile_delete_message", "0");
		} finally {
			try {
				dispatcher = request.getRequestDispatcher(GO_TO_PAGE);
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				logger.error("ServiceJobSeekerImpl: deleteProfile: " + e);
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
		RequestDispatcher dispatcher = null;

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
			profile = daoJobSeeker.updateOldProfile(idUser, registrationDate, photoPath, phone, birthDayDate, residence,
					workSpeciality, workExpirience, education, aboutUser);
			if (profile != null) {
				request.setAttribute("profile_update_message", "1");
				session.removeAttribute(ServiceParamConstant.PROFILE_ATTRIBUTE);
				session.setAttribute(ServiceParamConstant.PROFILE_ATTRIBUTE, profile);
			} else {
				request.setAttribute("profile_update_message", "0");
			}
		} catch (DaoException e1) {
			logger.error("ServiceJobSeekerImpl: updateProfile: " + e1);
			request.setAttribute("profile_update_message", "0");
		} finally {
			dispatcher = request.getRequestDispatcher(GO_TO_PAGE);
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				logger.error("ServiceJobSeekerImpl: updateProfile: " + e);
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
		RequestDispatcher dispatcher = null;

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
			user = daoJobSeeker.addNewResume(name, surName, email, registrationDate, birthDayDate, phone, residence,
					workSpeciality, workExpirience, education, photoPath, aboutUser, idUser);
			if (user != null) {
				request.setAttribute("resume_add_message", "1");
				session.removeAttribute(ServiceParamConstant.USER_ATTRIBUTE);
				session.setAttribute(ServiceParamConstant.USER_ATTRIBUTE, user);
			} else {
				request.setAttribute("resume_add_message", "0");
			}
		} catch (DaoException e1) {
			logger.error("ServiceJobSeekerImpl: addResume: " + e1);
			request.setAttribute("resume_add_message", "0");
		} finally {
			try {
				dispatcher = request.getRequestDispatcher(GO_TO_PAGE);
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				logger.error("ServiceJobSeekerImpl: addResume: " + e);
			}
		}
	}

	@Override
	public void deleteResume(final HttpServletRequest request, final HttpServletResponse response) {

		String resumeId = null;
		User user = null;
		RequestDispatcher dispatcher = null;

		session = request.getSession();
		resumeId = request.getParameter(ServiceParamConstant.USER_RESUME_ID__PARAM);
		System.out.println(resumeId);
		try {
			user = daoJobSeeker.deleteResume(Integer.parseInt(resumeId));
			if (user != null) {
				request.setAttribute("resume_delete_message", "1");
				session.removeAttribute(ServiceParamConstant.USER_ATTRIBUTE);
				session.setAttribute(ServiceParamConstant.USER_ATTRIBUTE, user);
			} else {
				request.setAttribute("resume_delete_message", "0");
			}
		} catch (NumberFormatException | DaoException e1) {
			logger.error("ServiceJobSeekerImpl: deleteResume: " + e1);
			request.setAttribute("resume_delete_message", "0");
		} finally {
			try {
				dispatcher = request.getRequestDispatcher(GO_TO_PAGE);
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				logger.error("ServiceJobSeekerImpl: deleteResume: " + e);
			}
		}
	}
}
