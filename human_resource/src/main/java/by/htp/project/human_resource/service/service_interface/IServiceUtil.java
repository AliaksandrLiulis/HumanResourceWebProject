package by.htp.project.human_resource.service.service_interface;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This Interface which has methods for work with Util on the Service layer
 */
public interface IServiceUtil {

	/**
	 * method for return user on the previous page 
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 * @throws {@link ServletException}, {@link IOException}
	 */
	void backOnPageByUserRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	/**
	 * method for change localization on the page
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 * @throws {@link IOException}
	 */
	void changeLocal(HttpServletRequest request, HttpServletResponse response) throws IOException;

	/**
	 * method for change write new message from {@link User}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 * @throws {@link IOException}
	 */
	void writeMessage(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
