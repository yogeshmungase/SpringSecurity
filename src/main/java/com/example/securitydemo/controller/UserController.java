package com.example.securitydemo.controller;


import com.example.securitydemo.model.dto.ChangePasswordDto;
import com.example.securitydemo.model.dto.UserInformationDto;
import com.example.securitydemo.model.dto.UserLoginDto;
import com.example.securitydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/public/user/signup")
    public ResponseEntity<UserInformationDto> signUpUser(@RequestBody UserInformationDto userInformationDto){
        UserInformationDto userInformation1 = userService.signUpUser(userInformationDto).getBody();
        return ResponseEntity.ok(userInformationDto);

    }

    @PostMapping("/public/user/login")
    public ResponseEntity<UserLoginDto> signUpUser(@RequestBody UserLoginDto userLoginDto){
        UserLoginDto userLogin = userService.signInUser(userLoginDto).getBody();
        return ResponseEntity.ok(userLogin);

    }

    @PostMapping("/api/user/change/password/{userId}")
    public String changePassword(@RequestBody ChangePasswordDto changePasswordDto, @PathVariable String userId){
            return userService.changePassword(changePasswordDto,userId);
    }

    @DeleteMapping("api/user/delete/{userId}")
    public String deleteProfile(@PathVariable String userId){
        return userService.deleteProfile(userId);
    }
}
