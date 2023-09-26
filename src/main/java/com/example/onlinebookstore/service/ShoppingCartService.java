package com.example.onlinebookstore.service;

import com.example.onlinebookstore.dto.CartItemDto;
import com.example.onlinebookstore.dto.CreateCartItemRequestDto;
import com.example.onlinebookstore.dto.ShoppingCartDto;
import com.example.onlinebookstore.dto.UpdateCartItemDto;
import java.util.Set;

public interface ShoppingCartService {
    ShoppingCartDto getShoppingCart(Long id);

    UpdateCartItemDto update(UpdateCartItemDto cartItemDto, Long id);

    void delete(Long id);

    CartItemDto save(CreateCartItemRequestDto requestDto, Long id);

    Set<CartItemDto> findByShoppingCart(Long id);
}