package com.mydao.split.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class LoginFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(LoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("过滤器初始化。。。");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        if (session.getAttribute("user")!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            String requestType = request.getHeader("X-Requested-With");
            if (requestType != null && "XMLHttpRequest".equals(requestType)){
                response.getWriter().write("未登陆！");
            }else{
                response.sendRedirect(request.getContextPath()+"/login.html");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
