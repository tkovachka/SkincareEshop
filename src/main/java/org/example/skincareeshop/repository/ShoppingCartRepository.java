package org.example.skincareeshop.repository;

import org.example.skincareeshop.models.ShoppingCart;
import org.example.skincareeshop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    ShoppingCart findByUserLike(User u);
}

