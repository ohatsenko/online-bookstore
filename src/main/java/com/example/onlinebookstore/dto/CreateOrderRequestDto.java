package com.example.onlinebookstore.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CreateOrderRequestDto {
    @NotNull
    @Length(min = 10, max = 255)
    private String shippingAddress;
}
