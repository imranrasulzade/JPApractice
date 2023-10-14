//package com.matrix.examplejpaapp.filter;
//
//import com.matrix.examplejpaapp.service.AuthService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//import org.springframework.security.core.Authentication;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Optional;
//
//@Slf4j
//@RequiredArgsConstructor
//public class JwtFilter extends OncePerRequestFilter {
//
//    private final List<AuthService> authServices;
//
//    @Override
//    protected void doFilterInternal(@org.springframework.lang.NonNull HttpServletRequest request,
//                                    @org.springframework.lang.NonNull HttpServletResponse response,
//                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
//
//        log.info("Auth service filtering");
//        Optional<Authentication> authOptional = Optional.empty();
//        for (AuthService authService: authServices){
//            authOptional = authOptional.or(() -> authService.getAuthentication(request));
//        }
//        authOptional.ifPresent(auth -> SecurityContextHolder.getContext().setAuthentication(auth));
//        filterChain.doFilter(request, response);
//
//    }
//}
