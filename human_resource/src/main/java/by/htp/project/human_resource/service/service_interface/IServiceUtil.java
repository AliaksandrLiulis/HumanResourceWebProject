package by.htp.project.human_resource.service.service_interface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IServiceUtil {
	void backOnPageByUserRole(HttpServletRequest request, HttpServletResponse response);
	void changeLocal(HttpServletRequest request,  HttpServletResponse response);
	void writeMessage(HttpServletRequest request, HttpServletResponse response);
}
