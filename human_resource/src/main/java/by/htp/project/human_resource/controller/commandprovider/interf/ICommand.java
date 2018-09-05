package by.htp.project.human_resource.controller.commandprovider.interf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Interface which must implement commands when they are working with
 * invoker
 */

public interface ICommand {

	/**
	 * The method which execute on the invoker
	 * 
	 * @param request  object that contains the request the client has made of the
	 *                 servlet
	 * @param response object that contains the response the servlet sends to the
	 *                 client
	 */

	void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
