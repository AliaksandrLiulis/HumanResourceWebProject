package by.htp.project.human_resource.service.interf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IServiceUser {
	
	void logInUser(final HttpServletRequest request, final HttpServletResponse response);
	void registerUser(final HttpServletRequest request, final HttpServletResponse response);
	void logOutUser (final HttpServletRequest request, final HttpServletResponse response);	
	
}
