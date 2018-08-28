package by.htp.project.human_resource.service.service_interface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IServiceJobSeeker {
	
	void addProfile(final HttpServletRequest request, final HttpServletResponse response);
	void deleteProfile(final HttpServletRequest request, final HttpServletResponse response);
	void updateProfile(final HttpServletRequest request, final HttpServletResponse response);
	void addResume(final HttpServletRequest request, final HttpServletResponse response);
	void deleteResume(final HttpServletRequest request, final HttpServletResponse response);
	void getVacancy(HttpServletRequest request, HttpServletResponse response);
	void respondOnvacancy(HttpServletRequest request, HttpServletResponse response);
	
}
