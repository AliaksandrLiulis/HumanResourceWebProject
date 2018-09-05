package by.htp.project.human_resource.service.service_interface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This Interface wich has metods for work with Hr on the Service layer
 */

public interface IServiceHr {

	/**
	 * method which add {@link Vacancy} for {@link Hr}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 */
	void addVacancy(HttpServletRequest request, HttpServletResponse response);

	/**
	 * method which get {@link Vacancy} for {@link Hr}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 */
	void getVacancy(HttpServletRequest request, HttpServletResponse response);

	/**
	 * method which delete {@link Vacancy} by {@link Vacancy#idvacancy}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 */
	void deleteVacancyById(HttpServletRequest request, HttpServletResponse response);

	/**
	 * method which get all {@link Resume} for {@link Hr}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse
	 * @return void
	 */
	void getResume(HttpServletRequest request, HttpServletResponse response);

	/**
	 * method which get all {@link RespondVacancy} for {@link Hr}
	 * @param request  is HTTPRequest
	 * @param response is HTTPResponse 
	 * @return void
	 */
	void getAllVacancyResponded(HttpServletRequest request, HttpServletResponse response);

}
