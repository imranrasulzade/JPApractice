package com.matrix.examplejpaapp.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class JwtServiceee {

    @Value("${application.security.jwt.secret-key}")
    private String secretKey;
    @Value("${application.security.jwt.expiration}")
    private long jwtExpiration;
    @Value("${application.security.jwt.refresh-token.expiration}")
    private long refreshExpiration;


    private Key key;


    public Key initializeKey(){
        byte[] keyBytes;

        keyBytes = Decoders.BASE64.decode(secretKey);
        key = Keys.hmacShaKeyFor(keyBytes);

        System.out.println(key);
        return key;
    }

    public String issueToken(Authentication authentication, Duration duration){
        log.trace("JWT token user {} duration {}", authentication.getPrincipal(), duration);
        initializeKey();
        final JwtBuilder jwtBuilder = Jwts.builder()
                .setSubject(authentication.getName())
                .setIssuedAt(new Date())
                .setExpiration(Date.from(Instant.now().plus(duration)))
                .addClaims(Map.of("roles", Set.of("ADMIN", "OPERATOR"), "user", "imran"))
                .signWith(key, SignatureAlgorithm.HS512);

        //addClaimsSets(jwtBuilder, authentication); map.ofun yerine yazilmalidi

        return jwtBuilder.compact();
    }

    public Claims parseToken(String token){
        initializeKey();
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
