package com.example.onlinebookstore.dto;

import com.example.onlinebookstore.validation.FieldMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@FieldMatch(first = "password", second = "repeatPassword", message = "Passwords do not match")
public class UserLoginResponseDto {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Length(min = 6, max = 20)
    private String password;

    @NotBlank
    @Length(min = 6, max = 20)
    private String repeatPassword;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String shippingAddress;

    public UserLoginResponseDto(String token) {
    }
}
