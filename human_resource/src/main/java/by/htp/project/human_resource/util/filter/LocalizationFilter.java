package by.htp.project.human_resource.util.filter;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.project.human_resource.controller.commandprovider.command.general_command.constant_for_command.ParamConst;
import by.htp.project.human_resource.service.service_constant.ServiceCommandConstant;
import by.htp.project.human_resource.service.service_constant.ServiceParamConstant;

public class LocalizationFilter implements Filter {

	private HttpSession session = null;

	public void init(FilterConfig arg0) throws ServletException {
	}

	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		session = httpServletRequest.getSession();

		if (!httpServletRequest.getParameter(ServiceParamConstant.COMMAND)
				.equals(ServiceCommandConstant.COMMAND_FOR_LOCALIZATION)) {

			String tempPath = "?";
			String previousServletPath = httpServletRequest.getRequestURI();

			Map<String, String[]> allParamsFromRequest = httpServletRequest.getParameterMap();

			Set<Entry<String, String[]>> set = allParamsFromRequest.entrySet();

			for (Entry<String, String[]> iterable_element : set) {

				String key = iterable_element.getKey();

				for (String value : iterable_element.getValue()) {

					tempPath = tempPath + key + "=" + value + "&";
				}
			}

			tempPath = tempPath.substring(0, tempPath.length() - 1);
			previousServletPath = previousServletPath + tempPath;

			session.setAttribute(ServiceCommandConstant.PREVIOUS_PATH_FOR_LOCALIZATION, previousServletPath);
			session.setAttribute(ServiceParamConstant.COMMAND, httpServletRequest.getParameter(ParamConst.COMMAND));
		}
		chain.doFilter(httpServletRequest, response);
	}

	public void destroy() {
	}
}
