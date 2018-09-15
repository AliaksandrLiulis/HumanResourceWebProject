package by.htp.project.human_resource.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	private String encodingRequestParams;
	private String encodingResponseParams;

	public void init(final FilterConfig filterConfig) throws ServletException {
		this.encodingRequestParams = filterConfig.getInitParameter("request_encoding");
		this.encodingResponseParams = filterConfig.getInitParameter("response_encoding");
		if (encodingRequestParams == null) {
			this.encodingRequestParams = "UTF-8";
		}
		if (encodingResponseParams == null) {
			this.encodingResponseParams = "text/html;charset=UTF-8";
		}
	}

	public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain)
			throws IOException, ServletException {
		servletRequest.setCharacterEncoding(encodingRequestParams);
		servletResponse.setContentType(encodingResponseParams);
		filterChain.doFilter(servletRequest, servletResponse);
	}

	public void destroy() {
	}
}
