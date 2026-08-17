package com.samarpit.LibraryManagementSystemAPI.controller;

import com.samarpit.LibraryManagementSystemAPI.dto.AuthenticationRequest;
import com.samarpit.LibraryManagementSystemAPI.dto.AuthenticationResponse;
import com.samarpit.LibraryManagementSystemAPI.dto.RegisterRequest;
import com.samarpit.LibraryManagementSystemAPI.security.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationService service;

    public AuthController(AuthenticationService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}