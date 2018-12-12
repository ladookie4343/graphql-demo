package com.example.graphql.graphqldemo.controller;

import com.example.graphql.graphqldemo.LoginRequest;
import com.example.graphql.graphqldemo.LoginResponse;
import com.example.graphql.graphqldemo.domain.DB;
import com.example.graphql.graphqldemo.domain.User;
import com.example.graphql.graphqldemo.service.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/login")
    @CrossOrigin("${cors.allowed.origin}")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) throws Exception {
        User u = DB.getUser(loginRequest);

        if (u != null) {
            LoginResponse response = new LoginResponse(TokenService.createJWT(u.getId()));
            return ResponseEntity.ok(response);
        }

        return (ResponseEntity<LoginResponse>) ResponseEntity.status(HttpStatus.UNAUTHORIZED);
    }
}
