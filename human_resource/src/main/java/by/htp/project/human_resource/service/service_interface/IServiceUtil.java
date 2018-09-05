package by.htp.project.human_resource.service.service_interface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This Interface wich has metods for work with Util on the Service layer
 */
public interface IServiceUtil {

	/**
	 * method wich return user on the previos page
	 * 
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 */
	void backOnPageByUserRole(HttpServletRequest request, HttpServletResponse response);

	/**
	 * method wich change localization on the page
	 * 
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 */
	void changeLocal(HttpServletRequest request, HttpServletResponse response);

	/**
	 * method wich change write new message from {@link User}
	 * 
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 */
	void writeMessage(HttpServletRequest request, HttpServletResponse response);
}
