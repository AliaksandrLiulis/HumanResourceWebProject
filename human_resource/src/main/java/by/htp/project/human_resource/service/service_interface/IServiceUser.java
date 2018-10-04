package by.htp.project.human_resource.service.service_interface;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This Interface which has methods for work with User on the Service layer
 */

public interface IServiceUser {
	
	/**
	 * method for login {@link User}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 * @throws {@link ServletException}, {@link IOException}
	 */
	void logInUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	/**
	 * method for register {@link User}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 * @throws {@link ServletException}, {@link IOException}
	 */
	void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	/**
	 * method for logOut {@link User}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 * @throws {@link IOException}
	 */
	void logOutUser (HttpServletRequest request, HttpServletResponse response) throws IOException;	
	
}
