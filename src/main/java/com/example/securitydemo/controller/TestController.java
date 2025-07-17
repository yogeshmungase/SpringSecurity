package com.example.securitydemo.controller;

import com.example.securitydemo.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping("/jwt/create/token/{emailId}")
    public String getToken(@PathVariable String emailId){
        return jwtUtil.createToken(emailId);
    }
}
