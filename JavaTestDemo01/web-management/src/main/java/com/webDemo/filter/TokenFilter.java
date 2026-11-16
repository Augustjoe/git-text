package com.webDemo.filter;

import com.webDemo.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.coyote.Request;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//@WebFilter("/*")
public class TokenFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if(httpRequest.getRequestURI().contains("/login")){
            chain.doFilter(request, response);
            return;
        }

        String token = httpRequest.getHeader("token");
        if(token == null || token.isEmpty()){
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        try{
            JwtUtils.parseJwt(token);
            chain.doFilter(request, response);
            return;
        }catch (Exception e){
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }



    }
}
