package by.htp.project.human_resource.service.service_interface;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project.human_resource.entity.Hr;

/**
 * This Interface which has methods for work with Hr on the Service layer
 */

public interface IServiceHr {

	/**
	 * method for add {@link Vacancy} for {@link Hr}
	 * 
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 * @throws ({@link IOException}
	 */
	void addVacancy(HttpServletRequest request, HttpServletResponse response) throws IOException;

	/**
	 * method for get {@link Vacancy} for {@link Hr}
	 * 
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 * @throws ({@link ServletException, IOException}
	 */
	void getVacancy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	/**
	 * method for delete {@link Vacancy} by {@link Vacancy#idvacancy}
	 * 
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 * @throws ({@link ServletException, IOException}
	 */
	void deleteVacancyById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	/**
	 * method for get all {@link Resume} for {@link Hr}
	 * 
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 * @throws ({@link ServletException, IOException}
	 */
	void getResume(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	/**
	 * method for get all {@link RespondVacancy} for {@link Hr}
	 * 
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 * @throws ({@link ServletException, IOException}
	 */
	void getAllVacancyResponded(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

}
