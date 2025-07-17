package com.example.securitydemo.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    // Creating the token
    private  final String SECRET_KEY = "YogeshMungase";
    private  final long TOKEN_EXPIRY_DURATION = 5 * 60000;
    public String createToken(String emailId){

        String token = Jwts
                .builder()
                .setSubject(emailId) // unique userId
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRY_DURATION))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
        return token;
    }
}
