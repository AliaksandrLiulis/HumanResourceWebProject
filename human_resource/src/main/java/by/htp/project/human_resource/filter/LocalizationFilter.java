package by.htp.project.human_resource.filter;

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

public class LocalizationFilter implements Filter {

	private final String COMMAND = "command";
	private final String COMMAND_FOR_LOCALIZATION = "cb.localization";

	public void init(FilterConfig arg0) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;

		if (!httpServletRequest.getParameter(COMMAND).equals(COMMAND_FOR_LOCALIZATION)) {

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
			
			System.out.println(previousServletPath);
			
			httpServletRequest.getSession(true).setAttribute("previousServletPath", previousServletPath);
			httpServletRequest.getSession(true).setAttribute("command", httpServletRequest.getParameter(COMMAND));

		}

		chain.doFilter(httpServletRequest, response);
	}

	public void destroy() {
	}

}
