package com.example.securitydemo.model.dto;

public class UserInformationDto {
    private String emailId;
    private String password;
    private String mobileNumber;
    private String userName;

    public UserInformationDto() {
    }

    public UserInformationDto(String emailId, String password, String mobileNumber, String userName) {
        this.emailId = emailId;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.userName = userName;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserInformation{" +
                "emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
