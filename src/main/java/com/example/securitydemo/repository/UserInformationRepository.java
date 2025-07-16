package com.example.securitydemo.repository;


import com.example.securitydemo.model.dto.UserLoginDto;
import com.example.securitydemo.model.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserInformationRepository extends JpaRepository<UserDetails, String> {

    Optional<UserDetails> findByEmailId(String emailId);

    Optional<UserDetails> findByEmailIdAndPassword(String emailId, String password);
}
