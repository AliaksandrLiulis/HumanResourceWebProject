package by.htp.project.human_resource.service.service_interface;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * This Interface which has methods for work with Job Seeker on the Service layer
 */

public interface IServiceJobSeeker {
	
	/**
	 * method for add {@link Profile} for {@link User}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 * @throws {@link IOException}
	 */
	void addProfile(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	/**
	 * method for delete {@link Profile} for {@link User}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 * @throws {@link IOException}
	 */
	void deleteProfile(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	/**
	 * method for update {@link Profile} for {@link User}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 * @throws {@link IOException}
	 */
	void updateProfile( HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	/**
	 * method for add {@link Resume} for {@link User}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse 
	 * @return void
	 * @throws {@link IOException}
	 */
	void addResume(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	/**
	 * method for delete {@link Resume} for {@link User}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 * @throws {@link IOException}
	 */
	void deleteResume( HttpServletRequest request,  HttpServletResponse response) throws IOException;
	
	/**
	 * method for get all {@link Vacancy} from {@link Hr}
	 * 
	 * @return void
	 * @throws  {@link ServletException}, {@link IOException}
	 */
	void getVacancy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	/**
	 * method for respond on {@link Vacancy} for {@link User}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void	 
	 * @throws {@link IOException}
	 */
	void respondOnvacancy(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	/**
	 * method for delete respond on {@link Vacancy} for {@link User}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 * @throws {@link IOException}
	 */
	void deleteRespondOnVacancy(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
}
