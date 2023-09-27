package com.example.onlinebookstore.dto;

import lombok.Data;

@Data
public class CartItemDto {
    private Long id;
    private String title;
    private Integer quantity;
    private Long bookId;
}
