package by.htp.project.human_resource.service.service_interface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IServiceAdmin {
	
	void getRegisteredUserByParam(final HttpServletRequest request, final HttpServletResponse response);
	void getUnRegisteredUserByParam(final HttpServletRequest request, final HttpServletResponse response);
	void getALLUserByParam(final HttpServletRequest request, final HttpServletResponse response);
	void deleteUser(final HttpServletRequest request, final HttpServletResponse response);
	void addUser(final HttpServletRequest request, final HttpServletResponse response);

}
