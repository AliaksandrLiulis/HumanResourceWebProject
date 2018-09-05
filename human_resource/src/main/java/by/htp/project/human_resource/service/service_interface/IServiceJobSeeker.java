package by.htp.project.human_resource.service.service_interface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * This Interface wich has metods for work with Job Seeker on the Service layer
 */

public interface IServiceJobSeeker {
	
	/**
	 * method which add {@link Profile} for {@link User}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 */
	void addProfile(HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * method which delete {@link Profile} for {@link User}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 */
	void deleteProfile(HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * method which update {@link Profile} for {@link User}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 */
	void updateProfile( HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * method which add {@link Resume} for {@link User}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse 
	 * @return void
	 */
	void addResume(HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * method which delete {@link Resume} for {@link User}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 */
	void deleteResume( HttpServletRequest request,  HttpServletResponse response);
	
	/**
	 * method which get all {@link Vacancy} from {@link Hr}
	 * 
	 * @return void
	 */
	void getVacancy(HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * method which respond on {@link Vacancy} for {@link User}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 */
	void respondOnvacancy(HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * method which delete respond on {@link Vacancy} for {@link User}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 */
	void deleteRespondOnVacancy(HttpServletRequest request, HttpServletResponse response);
	
}
