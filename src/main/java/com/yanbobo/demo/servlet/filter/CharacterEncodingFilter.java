package com.yanbobo.demo.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @describe: 自己手写编码过滤器（方式二）
 * @author: yanbobo
 * @createdate: 2019/3/15 16:57
 */
@WebFilter(urlPatterns = "/*")
public class CharacterEncodingFilter implements Filter {

    private static final String CHARACTER_ENCODING_DEFAULT = "UTF-8";
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding(CHARACTER_ENCODING_DEFAULT);
        response.setCharacterEncoding(CHARACTER_ENCODING_DEFAULT);

        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
