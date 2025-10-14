package com.learning.example.practice.springpracticesession3.Filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JWTTokenValidator extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String jsonWebToken = request.getHeader("JsonWebToken");
        Environment environment=getEnvironment();
        if (jsonWebToken!=null)
        {
            String property = environment.getProperty("JWT_SECRET_KEY", "and0c2VjcmV0LWtleS1EaW5hdXNlciQxMjM0NQ");
            SecretKey secretKey = Keys.hmacShaKeyFor(property.getBytes(StandardCharsets.UTF_8));
            try {
                Claims payload = Jwts.parser().verifyWith(secretKey).build()
                        .parseSignedClaims(jsonWebToken).getPayload();
                String userName = String.valueOf(payload.get("userName"));
                String authority = String.valueOf(payload.get("authority"));
                Authentication authentication =
                        new UsernamePasswordAuthenticationToken(userName, null,
                                AuthorityUtils.commaSeparatedStringToAuthorityList(authority));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            catch (BadCredentialsException e)
            {
                throw  new BadCredentialsException("Invalid Authentication please check and try again");
            }

        }
        filterChain.doFilter(request,response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return request.getServletPath().equals("/login/loginUser");
    }
}
