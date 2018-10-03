package by.htp.project.human_resource.util.filter;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class InjectionFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		Map<String, String[]> allParamsFromRequest = httpServletRequest.getParameterMap();
		Set<Entry<String, String[]>> set = allParamsFromRequest.entrySet();
		for (Entry<String, String[]> entry : set) {
			String key = entry.getKey();
			String[] values = entry.getValue();			
			for(String string:values) {
				if (!test(string)) {
					String newValue = string.replace('>', '|');
					String value = newValue.replace('<', '|');					
					
					System.out.println(value);
				}
			}
			
			
		}

			chain.doFilter(httpServletRequest, response);
		
	}
	
	public static boolean test(String testString){  
        Pattern p = Pattern.compile("^[a-z0-9._-]+");  
        Matcher m = p.matcher(testString);  
        return m.matches();  
    } 

	@Override
	public void destroy() {

	}

}
