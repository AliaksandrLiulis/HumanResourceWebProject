package by.htp.project.human_resource.service.service_interface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IServiceJobSeeker {
	
	void addProfile(HttpServletRequest request, HttpServletResponse response);
	void deleteProfile(HttpServletRequest request, HttpServletResponse response);
	void updateProfile( HttpServletRequest request, HttpServletResponse response);
	void addResume(HttpServletRequest request, HttpServletResponse response);
	void deleteResume( HttpServletRequest request,  HttpServletResponse response);
	void getVacancy(HttpServletRequest request, HttpServletResponse response);
	void respondOnvacancy(HttpServletRequest request, HttpServletResponse response);
	void deleteRespondOnVacancy(HttpServletRequest request, HttpServletResponse response);
	
}
