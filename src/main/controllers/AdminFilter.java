package main.controllers;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 25.04.2017.
 */
//@WebFilter("/main","/profile")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String userLogin = (String) ((HttpServletRequest) servletRequest).getSession().getAttribute("login");
        String admin = (String) ((HttpServletRequest) servletRequest).getSession().getAttribute("admin");

        if (userLogin != null && admin.equals("True")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ((HttpServletResponse) servletResponse)
                    .sendRedirect(((HttpServletRequest) servletRequest).getContextPath() + "/login");
        }
    }

    @Override
    public void destroy() {

    }
}
