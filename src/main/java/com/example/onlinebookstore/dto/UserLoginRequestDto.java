package com.example.onlinebookstore.dto;

import com.example.onlinebookstore.validation.FieldMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@FieldMatch(first = "password", second = "repeatPassword", message = "Passwords do not match")
public class UserLoginRequestDto {
    @NotEmpty
    @Length(min = 5, max = 50)
    @Email
    private String email;
    @NotEmpty
    @Length(min = 6, max = 20)
    private String password;
}
