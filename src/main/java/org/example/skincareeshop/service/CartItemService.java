package org.example.skincareeshop.service;

import org.example.skincareeshop.models.CartItem;

import java.util.List;

public interface CartItemService {
    List<CartItem> findAll();

    CartItem findById(Long id);
    List<CartItem> findAllByShoppingCartId(Long id);
}
