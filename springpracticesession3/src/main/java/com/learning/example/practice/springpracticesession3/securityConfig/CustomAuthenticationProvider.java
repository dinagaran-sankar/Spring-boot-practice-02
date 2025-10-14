//package com.learning.example.practice.springpracticesession3.securityConfig;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//
//    private final UserDetailsService userDetailService;
//
//    private final PasswordEncoder passwordEncoder;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//
//        String name = authentication.getName();
//        String password = authentication.getCredentials().toString();
//        //System.out.println("password: " + password);
//        UserDetails userDetails = userDetailService.loadUserByUsername(name);
//        System.out.println("authenticatinprovier: " + userDetails.getAuthorities());
//        if (passwordEncoder.matches(password,userDetails.getPassword()))
//        {
//            return new UsernamePasswordAuthenticationToken(userDetails,password,
//                    userDetails.getAuthorities());
//        }
//        else {
//            throw new BadCredentialsException("username not found");
//        }
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
//    }
//}
