package com.example.onlinebookstore.dto;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class CreateCategoryRequestDto {
    @NotNull
    @Length(min = 1, max = 255)
    private String name;
    @Length(min = 1, max = 255)
    private String description;
}
