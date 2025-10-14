package com.learning.example.practice.springpracticesession3.OAuth2;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KeyCloakOAuth2Converter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt source) {
        Map<String,Object> realmAccess = (Map<String,Object>)source.getClaims().get("realm_access");

        if (realmAccess.isEmpty()&&realmAccess !=null)
        {
            return new ArrayList<>();
        }

        Collection<GrantedAuthority> roles = ((List<String>) realmAccess.get("roles"))
                .stream()
                .map(realAccess -> "ROLE_" + realAccess)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return roles;
    }
}
