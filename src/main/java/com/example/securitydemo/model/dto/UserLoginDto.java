package com.example.securitydemo.model.dto;

public class UserLoginDto {
    private String emailId;
    private String password;

    public UserLoginDto() {
    }

    public UserLoginDto(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
