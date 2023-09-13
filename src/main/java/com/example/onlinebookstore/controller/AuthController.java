package com.example.onlinebookstore.controller;

import com.example.onlinebookstore.dto.UserLoginRequestDto;
import com.example.onlinebookstore.dto.UserLoginResponseDto;
import com.example.onlinebookstore.dto.UserRegistrationRequestDto;
import com.example.onlinebookstore.dto.UserRegistrationResponseDto;
import com.example.onlinebookstore.exception.RegistrationException;
import com.example.onlinebookstore.security.AuthenticationService;
import com.example.onlinebookstore.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public UserLoginResponseDto login(@RequestBody @Valid UserLoginRequestDto request) {
        return authenticationService.authenticate(request);
    }

    @PostMapping("/register")
    public UserRegistrationResponseDto register(
            @RequestBody @Valid UserRegistrationRequestDto request
    ) throws RegistrationException {
        return userService.register(request);
    }
}
