package org.example.skincareeshop.service;

import org.example.skincareeshop.models.CartItem;
import org.example.skincareeshop.models.Order;


import java.util.List;

public interface OrderService {
    List<Order> findAll();
    Order findById(Long id);
    List<CartItem> getCartItemsFromShoppingCart(Long id);

    void placeOrder(Long shoppingCartId, String name, String email, String deliveryAddress, Boolean fastDelivery);
}
