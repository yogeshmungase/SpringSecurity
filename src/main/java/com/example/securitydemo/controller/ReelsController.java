package com.example.securitydemo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReelsController {

    @PostMapping("/api/upload/reel")
    public String uploadNewReel(){

        return "Reel is successfully uploaded";
    }
}
