package com.learning.example.practice.springpracticesession3.securityConfig;

import com.learning.example.practice.springpracticesession3.BasicExceptionHandling.BasicAccessdeniedException;
import com.learning.example.practice.springpracticesession3.BasicExceptionHandling.UserAuthenticationEntry;
import com.learning.example.practice.springpracticesession3.Filter.JWTTokenGenerator;
import com.learning.example.practice.springpracticesession3.Filter.JWTTokenValidator;
import com.learning.example.practice.springpracticesession3.OAuth2.KeyCloakOAuth2Converter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class PracticeSessionSecurity {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(new KeyCloakOAuth2Converter());

        http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // .addFilterAfter(new JWTTokenGenerator(), BasicAuthenticationFilter.class)
                // .addFilterBefore(new JWTTokenValidator(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests((request) -> request
                        .requestMatchers("/sesion-1/**").hasRole("USER")
                        .requestMatchers("/login/**").hasRole("LOGIN")
                        .requestMatchers("/RegisterRider/**").authenticated()

                )
                .oauth2ResourceServer(
                        rsc -> rsc.jwt(jwtConfigurer -> jwtConfigurer.jwtAuthenticationConverter(converter)))
                // .httpBasic(Customizer.withDefaults());
                .httpBasic(aep -> aep.authenticationEntryPoint(new UserAuthenticationEntry()))
                .exceptionHandling(ash -> ash.accessDeniedHandler(new BasicAccessdeniedException()));
        // .formLogin(hlc->hlc.disable();
        return (SecurityFilterChain) http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker() {
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }
}
