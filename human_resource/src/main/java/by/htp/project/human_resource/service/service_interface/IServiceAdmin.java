package by.htp.project.human_resource.service.service_interface;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This Interface which has methods for work with Administrator on the Service
 * layer
 */

public interface IServiceAdmin {

	/**
	 * method for get registered {@link User} by params
	 * 
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 * @throws {@link ServletException}, {@link IOException}
	 */
	void getRegisteredUserByParam(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	/**
	 * method for get UnRegistered {@link User} by params
	 * 
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 * @throws {@link ServletException}, {@link IOException}
	 */
	void getUnRegisteredUserByParam(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	/**
	 * method for get All {@link User} by params
	 * 
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 * @throws {@link ServletException}, {@link IOException}
	 */
	void getALLUserByParam(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	/**
	 * method for delete {@link User}
	 * 
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 * @throws {@link IOException}
	 */
	void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException;

	/**
	 * method for add {@link User}
	 * 
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 * @throws {@link IOException}
	 */
	void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException;

	/**
	 * method for gets {@link Message}
	 * 
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 * @throws {@link ServletException}, {@link IOException}
	 */
	void getAllMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	/**
	 * method for delete {@link Message}
	 * 
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 * @throws {@link IOException}
	 */
	void deleteMessage(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	/**
	 * method for deleteUserFromBase
	 * 
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 * @throws {@link IOException}
	 */
	void deleteUserFromBase(HttpServletRequest request, HttpServletResponse response) throws IOException;
	

}
