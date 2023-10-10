package com.example.onlinebookstore.dto;

import com.example.onlinebookstore.model.Order;
import lombok.Data;

@Data
public class UpdateStatusOrderDto {
    private Order.Status status;
}
