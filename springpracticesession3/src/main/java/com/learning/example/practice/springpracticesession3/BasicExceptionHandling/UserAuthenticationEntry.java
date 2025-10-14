package com.learning.example.practice.springpracticesession3.BasicExceptionHandling;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;
import java.time.LocalDateTime;

public class UserAuthenticationEntry implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        LocalDateTime now = LocalDateTime.now();
        String requestURI = request.getRequestURI();

        String s = (authException.getMessage() != null && authException!=null)
                ? authException.getMessage() : "unauthorized";

        response.setHeader("Spring practice session 3 ","authorization failed");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json;charset=UTF-8");
        String jsonResponse= String.format(("{\"timestamp\": \"%s\", \"status\": %d, \"error\": \"%s\", " +
                        "\"message\": \"%s\", \"path\": \"%s\"}")
                ,now,HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase()
                ,s,requestURI);

        response.getWriter().write(jsonResponse);
    }
}
