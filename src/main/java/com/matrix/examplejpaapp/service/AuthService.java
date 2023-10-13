package com.matrix.examplejpaapp.service;


import org.springframework.security.core.Authentication;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface AuthService {

    Optional<Authentication> getAuthentication(HttpServletRequest request);
}
