//package com.matrix.examplejpaapp.controller;
//
//import com.matrix.examplejpaapp.model.dto.LoginReq;
//import com.matrix.examplejpaapp.model.dto.LoginRes;
//import com.matrix.examplejpaapp.service.impl.AuthenticationServiceImpl;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/sign")
//public class LoginController {
//    private final AuthenticationServiceImpl service;
//    @PostMapping("/in")
//    public LoginRes authenticate(@RequestBody LoginReq loginReq){
//        return service.authenticate(loginReq);
//    }
//
//}
