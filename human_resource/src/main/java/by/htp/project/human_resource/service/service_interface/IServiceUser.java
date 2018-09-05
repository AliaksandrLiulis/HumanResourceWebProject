package by.htp.project.human_resource.service.service_interface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This Interface wich has metods for work with User on the Service layer
 */

public interface IServiceUser {
	
	/**
	 * method which login {@link User}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 */
	void logInUser(HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * method which register {@link User}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 */
	void registerUser(HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * method which logOut {@link User}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 */
	void logOutUser (HttpServletRequest request, HttpServletResponse response);	
	
}
