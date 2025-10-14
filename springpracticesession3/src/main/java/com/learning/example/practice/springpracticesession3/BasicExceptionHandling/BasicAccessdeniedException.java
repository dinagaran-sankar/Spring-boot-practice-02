package com.learning.example.practice.springpracticesession3.BasicExceptionHandling;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;
import java.time.LocalDateTime;

public class BasicAccessdeniedException implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        LocalDateTime now = LocalDateTime.now();
        String servletPath = request.getRequestURI();
        String s = (accessDeniedException != null && accessDeniedException.getMessage()!=null)
                ? accessDeniedException.getMessage()
                : "Forbidden";
        response.setHeader("Spring practice ","Authorization not found");
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType("application/json;charset=UTF-8");
        String format = String.format("{" +
                "\n" +
                "   \"timestamp\": \"%s\",\n" +
                "   \"status\": \"%d\"\n" +
                "   \"error\": \"%s\",\n" +
                "   \"messages\":\"%s\",\n" +
                "   \"path\": \"%s\"\n" +
                "}", now,HttpStatus.FORBIDDEN.value(),
                HttpStatus.FORBIDDEN.getReasonPhrase(),s,servletPath);
        response.getWriter().write(format);
    }
}
