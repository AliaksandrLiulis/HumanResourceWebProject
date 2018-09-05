package by.htp.project.human_resource.service.service_interface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This Interface wich has metods for work with Administrator on the Service
 * layer
 */

public interface IServiceAdmin {

	/**
	 * method which get registered {@link User} by params
	 * 
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 */
	void getRegisteredUserByParam(HttpServletRequest request, HttpServletResponse response);

	/**
	 * method which get UnRegistered {@link User} by params
	 * 
	 * @return void
	 */
	void getUnRegisteredUserByParam(HttpServletRequest request, HttpServletResponse response);

	/**
	 * method which get All {@link User} by params
	 * 
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 */
	void getALLUserByParam(HttpServletRequest request, HttpServletResponse response);

	/**
	 * method which delete {@link User}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 */
	void deleteUser(HttpServletRequest request, HttpServletResponse response);

	/**
	 * method which add {@link User}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 */
	void addUser(HttpServletRequest request, HttpServletResponse response);

}
