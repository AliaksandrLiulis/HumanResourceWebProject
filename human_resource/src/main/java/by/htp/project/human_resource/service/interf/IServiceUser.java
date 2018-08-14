package by.htp.project.human_resource.service.interf;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project.human_resource.entity.User;
import by.htp.project.human_resource.service.exception.ServiceException;

public interface IServiceUser {
	
	void logInUser(final HttpServletRequest request, final HttpServletResponse response);
	void registerUser(final HttpServletRequest request, final HttpServletResponse response);
	void logOutUser (final HttpServletRequest request, final HttpServletResponse response);
	
	
	
	
	
	List<User> getAllUser() throws ServiceException;
	
	

}
