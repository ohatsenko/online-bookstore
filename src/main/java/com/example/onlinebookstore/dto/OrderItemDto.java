package com.example.onlinebookstore.dto;

import lombok.Data;

@Data
public class OrderItemDto {
    private Long id;
    private Long bookId;
    private Integer quantity;
}
