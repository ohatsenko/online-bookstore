package com.example.onlinebookstore.dto;

import com.example.onlinebookstore.validation.FieldMatch;
import lombok.Data;

@Data
@FieldMatch(first = "password", second = "repeatPassword", message = "Passwords do not match")
public class UserLoginResponseDto {
    private String email;
    private String password;
    private String repeatPassword;
    private String firstName;
    private String lastName;
    private String shippingAddress;
    private final String token;
}
