package com.example.securitydemo.service;


import com.example.securitydemo.model.dto.ChangePasswordDto;
import com.example.securitydemo.model.dto.UserInformationDto;
import com.example.securitydemo.model.dto.UserLoginDto;
import com.example.securitydemo.model.entity.UserDetails;
import com.example.securitydemo.repository.UserInformationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
   private UserInformationRepository userInformationRepository;
    @Autowired
    private ModelMapper modelMapper;
    public ResponseEntity<UserInformationDto> signUpUser(UserInformationDto dto) {

        // Convert DTO to Entity
        UserDetails userDetails = modelMapper.map(dto, UserDetails.class);
        if(userInformationRepository.findById(userDetails.getEmailId()).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email Already Existed");
//            return ResponseEntity.status(HttpStatus.CONFLICT)
//                    .body("Email Already Existed, Please Try with Other Email Id ");
        }
            UserDetails saveEntity = userInformationRepository.save(userDetails);
        UserInformationDto responseDto = modelMapper.map(saveEntity, UserInformationDto.class);
        // Convert back to DTO
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);

    }

    public ResponseEntity<UserLoginDto>signInUser(UserLoginDto userLoginDto) {

        // Find entity by email and password
        Optional<UserDetails> info = userInformationRepository
                .findByEmailIdAndPassword(userLoginDto.getEmailId(), userLoginDto.getPassword());

        if(info.isPresent()){
            UserDetails user = info.get();
            UserLoginDto responseDto = modelMapper.map(user, UserLoginDto.class);

            return ResponseEntity.status(HttpStatus.OK).body(responseDto);
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid Credentials");


    }

    public String changePassword(ChangePasswordDto changePasswordDto, String userId) {
        Optional<UserDetails> userDetails = userInformationRepository.findById(userId);
        if(userDetails.isPresent()){
            UserDetails userDetails1 = userDetails.get();
            userDetails1.setPassword(changePasswordDto.getNewPassword());
            userInformationRepository.save(userDetails1);

            return "Password Change Successfully";
        }else {
            return "User Not Found with Email ."+userId;
        }
    }

    public String deleteProfile(String userId) {
        Optional<UserDetails> userDetails = userInformationRepository.findById(userId);
        if(userDetails.isPresent()) {
            userInformationRepository.deleteById(userId);
            return "User Deleted Successfully";
        }else {
            return "User Not Found with Email ."+userId;
        }
    }
}
