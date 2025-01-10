package org.example.skincareeshop.service;

import org.example.skincareeshop.models.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    List<ShoppingCart> findAll();
    ShoppingCart findById(Long id);
    void emptyShoppingCart(Long id);
    ShoppingCart findByUserId(Long userId);

    void addProductToCart(Long userId, Long productId, Integer quantity);
    void deleteProductFromCart(Long userId, Long productId);
    void changeProductQuantity(Long userId, Long productId, Integer newQuantity);
}
