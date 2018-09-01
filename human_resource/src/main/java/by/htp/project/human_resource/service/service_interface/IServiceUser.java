package by.htp.project.human_resource.service.service_interface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IServiceUser {
	
	void logInUser(HttpServletRequest request, HttpServletResponse response);
	void registerUser(HttpServletRequest request, HttpServletResponse response);
	void logOutUser (HttpServletRequest request, HttpServletResponse response);	
	
}
