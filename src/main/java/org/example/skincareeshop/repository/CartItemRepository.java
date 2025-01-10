package org.example.skincareeshop.repository;

import org.example.skincareeshop.models.CartItem;
import org.example.skincareeshop.models.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findAllByShoppingCartLike(ShoppingCart shoppingCart);
}
