package com.matrix.examplejpaapp.service.impl;

import com.matrix.examplejpaapp.model.dto.LoginReq;
import com.matrix.examplejpaapp.model.dto.LoginRes;
import com.matrix.examplejpaapp.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationServiceImpl {
    private final StudentRepository repository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final TokenAuthService authService;

    public LoginRes authenticate(LoginReq request){

        return null;
        }




}
