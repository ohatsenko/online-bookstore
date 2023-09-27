package com.example.onlinebookstore.service.impl;

import com.example.onlinebookstore.dto.CartItemDto;
import com.example.onlinebookstore.dto.CreateCartItemRequestDto;
import com.example.onlinebookstore.dto.ShoppingCartDto;
import com.example.onlinebookstore.dto.UpdateCartItemDto;
import com.example.onlinebookstore.exception.EntityNotFoundException;
import com.example.onlinebookstore.mapper.CartItemMapper;
import com.example.onlinebookstore.mapper.ShoppingCartMapper;
import com.example.onlinebookstore.model.CartItem;
import com.example.onlinebookstore.model.ShoppingCart;
import com.example.onlinebookstore.repository.CartItemRepository;
import com.example.onlinebookstore.repository.ShoppingCartRepository;
import com.example.onlinebookstore.service.BookService;
import com.example.onlinebookstore.service.ShoppingCartService;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final CartItemRepository cartItemRepository;
    private final CartItemMapper cartItemMapper;
    private final ShoppingCartMapper shoppingCartMapper;
    private final BookService bookService;

    @Override
    public UpdateCartItemDto update(UpdateCartItemDto cartItemDto, Long id) {
        CartItem cartItem = cartItemRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't find Cart Item by id: " + id));
        cartItem.setQuantity(cartItemDto.getQuantity());
        cartItemRepository.save(cartItem);
        return cartItemMapper.toUpdateDto(cartItem);
    }

    @Override
    public void delete(Long id) {
        cartItemRepository.deleteById(id);
    }

    @Override
    public CartItemDto save(CreateCartItemRequestDto requestDto, Long userId) {
        CartItem cartItem = new CartItem();
        cartItem.setBook(bookService.findBookById(requestDto.getBookId()));
        cartItem.setShoppingCart(findShoppingCartByID(userId));
        cartItem.setQuantity(requestDto.getQuantity());
        return cartItemMapper.toDto(cartItemRepository.save(cartItem));
    }

    @Override
    public Set<CartItemDto> findByShoppingCart(Long id) {
        return cartItemRepository.findCartItemsByShoppingCartId(id).stream()
                .map(cartItemMapper::toDto)
                .collect(Collectors.toSet());
    }

    @Override
    public ShoppingCartDto getShoppingCart(Long id) {
        ShoppingCartDto shoppingCartDto = shoppingCartMapper.toDto(findShoppingCartByID(id));
        shoppingCartDto.setUserId(id);
        shoppingCartDto.setCartItems(findByShoppingCart(id));
        return shoppingCartDto;
    }

    private ShoppingCart findShoppingCartByID(Long id) {
        return shoppingCartRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Can't find shopping cart by id: " + id));
    }
}
