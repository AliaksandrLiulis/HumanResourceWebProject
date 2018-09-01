package by.htp.project.human_resource.service.service_interface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IServiceAdmin {
	
	void getRegisteredUserByParam(HttpServletRequest request, HttpServletResponse response);
	void getUnRegisteredUserByParam(HttpServletRequest request, HttpServletResponse response);
	void getALLUserByParam(HttpServletRequest request, HttpServletResponse response);
	void deleteUser(HttpServletRequest request, HttpServletResponse response);
	void addUser(HttpServletRequest request, HttpServletResponse response);

}
