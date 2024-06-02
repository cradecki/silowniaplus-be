package com.silowniaplus.controller;

import com.silowniaplus.reguest.LoginRequest;
import com.silowniaplus.token.JwtToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    @GetMapping("/message")
    public String getMainPage(){
        return "{\"message\": \"Hello from backend!!!\"}";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        String token = JwtToken.generateToken(username);

        return "Token: " + token;

        // ob
    }
}
