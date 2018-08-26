package by.htp.project.human_resource.service.service_interface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IServiceHr {
	void addVacancy(final HttpServletRequest request, final HttpServletResponse response);
	void getVacancy(final HttpServletRequest request, final HttpServletResponse response);
	void deleteVacancyById(final HttpServletRequest request, final HttpServletResponse response);
	void getResume(HttpServletRequest request, HttpServletResponse response);

}