package by.htp.project.human_resource.service.service_interface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IServiceUtil {
	void backOnPageByUserRole(final HttpServletRequest request, final HttpServletResponse response);
	void changeLocal(final HttpServletRequest request, final HttpServletResponse response);
	void writeMessage(final HttpServletRequest request, final HttpServletResponse response);
}
