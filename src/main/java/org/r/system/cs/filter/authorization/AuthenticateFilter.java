/**
 * 
 */
package org.r.system.cs.filter.authorization;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Casper
 * @WebFilter(filterName="AuthenticateFilter",urlPatterns="/*") @Component
 */

@WebFilter(filterName="AuthorizationFilter",urlPatterns="/api/*")
public class AuthenticateFilter implements Filter {

	private String[] allowUrl = { "/api/aut/token", "/api/aut/association/project" };

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String url = req.getRequestURI();
		String token = req.getHeader("Authorization");

		if (neadFilter(url)) {
			if (session.getAttribute("Authorization") == null || token == null
					|| !session.getAttribute("Authorization").equals(token)) {
				resp.setContentType("application/json;charset=UTF-8");
				resp.getWriter().write("{\"code\":\"404\",\"msg\":\"" + "用户未登陆" + "\"}");
			} else {
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {

	}

	private boolean neadFilter(String url) {
		for (String target : allowUrl) {
			if (url.indexOf(target) != -1)
				return false;
		}
		return true;
	}

}
