package by.htp.project.human_resource.service.service_interface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IServiceHr {
	void addVacancy(HttpServletRequest request, HttpServletResponse response);
	void getVacancy(HttpServletRequest request, HttpServletResponse response);
	void deleteVacancyById(HttpServletRequest request, HttpServletResponse response);
	void getResume(HttpServletRequest request, HttpServletResponse response);
	void getAllVacancyResponded(HttpServletRequest request, HttpServletResponse response);

}
