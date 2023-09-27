package com.example.onlinebookstore.service;

import com.example.onlinebookstore.dto.UserRegistrationRequestDto;
import com.example.onlinebookstore.dto.UserRegistrationResponseDto;
import com.example.onlinebookstore.exception.RegistrationException;
import com.example.onlinebookstore.model.User;

public interface UserService {
    UserRegistrationResponseDto register(UserRegistrationRequestDto request)
            throws RegistrationException;

    User getAuthenticatedUser();
}
