package com.example.securitydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @GetMapping("/public/contact/info")
    public String getContactInfo(){
        return "Call : 0987654321";
    }
}
