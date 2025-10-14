package com.learning.example.practice.springpracticesession3.Filter;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class JWTTokenGenerator extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Environment environment= getEnvironment();
        if (authentication!=null)
        {
            String jwtSecretKey = environment.getProperty("JWT_SECRET_KEY","and0c2VjcmV0LWtleS1EaW5hdXNlciQxMjM0NQ");

            SecretKey secretKey = Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
            String jwtRequest = Jwts.builder().issuer("Dinagaran Sankar").subject("JsonWebToken")
                    .claim("userName", authentication.getName())
                    .claim("authority", authentication.getAuthorities().stream()
                            .map(GrantedAuthority::getAuthority).collect(Collectors.joining(",")))
                    .issuedAt(new java.util.Date())
                    .expiration(new Date(new java.util.Date().getTime()+ 180000))
                    .signWith(secretKey)
                    .compact();
            System.out.println("json web token generator " + jwtRequest);
            response.setHeader("JsonWebToken",jwtRequest);
        }
        filterChain.doFilter(request,response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return request.getServletPath().equals("/login/loginUser");
    }
}
