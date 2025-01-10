package org.example.skincareeshop.service.impl;

import org.example.skincareeshop.exceptions.CartItemFoundException;
import org.example.skincareeshop.models.CartItem;
import org.example.skincareeshop.models.ShoppingCart;
import org.example.skincareeshop.repository.CartItemRepository;
import org.example.skincareeshop.service.CartItemService;
import org.example.skincareeshop.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;
    private final ShoppingCartService shoppingCartService;

    public CartItemServiceImpl(CartItemRepository cartItemRepository, ShoppingCartService shoppingCartService) {
        this.cartItemRepository = cartItemRepository;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public List<CartItem> findAll() {
        return cartItemRepository.findAll();
    }

    @Override
    public CartItem findById(Long id) {
        return cartItemRepository.findById(id).orElseThrow(() -> new CartItemFoundException(id));
    }

    @Override
    public List<CartItem> findAllByShoppingCartId(Long id) {
        ShoppingCart sc = shoppingCartService.findById(id);
        return cartItemRepository.findAllByShoppingCartLike(sc);
    }
}
