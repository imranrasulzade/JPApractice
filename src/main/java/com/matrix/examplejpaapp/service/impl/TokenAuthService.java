package com.matrix.examplejpaapp.service.impl;

import com.matrix.examplejpaapp.service.AuthService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TokenAuthService implements AuthService {

    private static final String ROLE_CLAIM = "roles";

    private final JwtServiceee jwtServiceee;
    @Override
    public Optional<Authentication> getAuthentication(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader("Authorization"))
                .filter(this::isBearerAuth)
                .flatMap(this::getAuthenticationBearer);
    }

    private Boolean isBearerAuth(String header){
        return header.toLowerCase().startsWith("bearer");
    }

    private Optional<Authentication> getAuthenticationBearer(String header){
         String token =  header.substring("Bearer".length()).trim();
        Claims claims = jwtServiceee.parseToken(token);
        log.info("claims parsed {}", claims);
        if(claims.getExpiration().before(new Date())){
            System.out.println("Expired");
            return Optional.empty();
        }
        return Optional.of(getAuthenticationBearer(claims));
    }


    private Authentication getAuthenticationBearer(Claims claims){
        List<?> roles = claims.get(ROLE_CLAIM, List.class);
        List<GrantedAuthority> authorityList = roles
                .stream()
                .map(auth -> new SimpleGrantedAuthority(auth.toString()))
                .collect(Collectors.toList());
        return new UsernamePasswordAuthenticationToken(claims.getSubject(), "", authorityList);
    }
}
