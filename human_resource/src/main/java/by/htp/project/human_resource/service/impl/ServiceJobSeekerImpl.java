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

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.htp.project.human_resource.dao.factory.DaoFactory;
import by.htp.project.human_resource.dao.interf.IDAOJodSeeker;
import by.htp.project.human_resource.entity.Profile;
import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.service.constant.ServiceJspPagePath;
import by.htp.project.human_resource.service.exception.ServiceException;
import by.htp.project.human_resource.service.interf.IServiceJobSeeker;

public class ServiceJobSeekerImpl implements IServiceJobSeeker{
	
	private final Logger logger = LogManager.getLogger(ServiceJobSeekerImpl.class);
	private HttpSession session = null;
	private final DaoFactory daoFactory = DaoFactory.getDaoFactory();
	private final IDAOJodSeeker daoJodSeeker = daoFactory.getDaoJodSeeker();
	
	@Override
	public void addProfile(final HttpServletRequest request, final HttpServletResponse response) {
		String profileId = null;
		String registrationDate = null;
		String birthDayDate = null;
		String phone = null;
		String residence = null;
		String workSpeciality = null;
		String workExpirience = null;
		String education = null;
		String photoPath;
		String abouteUser;
		String idUser = null;
		User user = null;
		List<Object> objectsList = null;
		Profile profile = null;
		String goToPage = null;
		RequestDispatcher dispatcher = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		
		idUser = request.getParameter("user_id");
		registrationDate = dateFormat.format(new Date());
		birthDayDate = request.getParameter("dateOfBirthDay");
		phone = request.getParameter("phone");
		residence = request.getParameter("residence");
		workSpeciality = request.getParameter("workSpeciality");
		workExpirience = request.getParameter("workExpirience");
		education = null;
		photoPath = request.getParameter("education");
		abouteUser = request.getParameter("message");
		
		objectsList = daoJodSeeker.addNewProfile(idUser, registrationDate, photoPath, phone, birthDayDate, residence, workSpeciality,
				workExpirience, education, abouteUser);
		
		if (objectsList != null) {
			if (objectsList.get(0) instanceof User) {
				user = (User)objectsList.get(0);
			}
			if (objectsList.get(1) instanceof Profile) {
				profile = (Profile)objectsList.get(1);
			}
			session = request.getSession();
			session.removeAttribute("user");
			goToPage = ServiceJspPagePath.PATH_EMPLOYEE_PAGE;
			session.setAttribute("user", user);
			session.setAttribute("profile", profile);
			
			
			dispatcher = request.getRequestDispatcher(goToPage);
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	


	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public User deleteProfile(int userId) throws ServiceException {
		return daoJodSeeker.removeProfile(userId);

	}

	@Override
	public Profile updateProfile(final String... profileParams) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		String UserId = profileParams[0];
		String registration_date = dateFormat.format(new Date());
		String photo = profileParams[1];
		String phone = profileParams[2];
		String birthDay = profileParams[3];
		String residence = profileParams[4];
		String workSpeciality = profileParams[5];
		String workExpirience = profileParams[6];
		String education = profileParams[7];
		String message = profileParams[8];
		Profile profile = null;
		profile = daoJodSeeker.updateOldProfile(UserId, registration_date, photo, phone, birthDay, residence, workSpeciality,
				workExpirience, education, message);
		return profile;
	}

	@Override
	public User addResume(String... resumeParams) {
		User user = daoJodSeeker.addNewResume(resumeParams);
		return user;

	}

	@Override
	public User deleteResume(int idUserResume) {
		User user = null;
		user = daoJodSeeker.deleteResume(idUserResume);
		return user;
	}

}
