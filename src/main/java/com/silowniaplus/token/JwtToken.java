package com.silowniaplus.token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtToken {
    private static final String SECRET_KEY = "bf9b3d423fd1d8fcf8fcd0dc626cf7462c593db04f1332f5062504dc7c4998e3";
    private static final long EXPIRATION_TIME = 300000; // 1 hour

    static public String generateToken(String username){
        Date now = new Date();
        Date expiryTime = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .subject(username)
                .issuedAt(now)
                .expiration(expiryTime)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
