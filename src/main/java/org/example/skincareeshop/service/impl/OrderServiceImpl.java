package org.example.skincareeshop.service.impl;

import org.example.skincareeshop.exceptions.OrderNotFoundException;
import org.example.skincareeshop.models.CartItem;
import org.example.skincareeshop.models.Order;
import org.example.skincareeshop.models.ShoppingCart;
import org.example.skincareeshop.models.User;
import org.example.skincareeshop.models.enums.PAYMENT_STATUS;
import org.example.skincareeshop.repository.OrderRepository;
import org.example.skincareeshop.service.CartItemService;
import org.example.skincareeshop.service.OrderService;
import org.example.skincareeshop.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CartItemService cartItemService;
    private final ShoppingCartService shoppingCartService;

    public OrderServiceImpl(OrderRepository orderRepository, CartItemService cartItemService, ShoppingCartService shoppingCartService) {
        this.orderRepository = orderRepository;
        this.cartItemService = cartItemService;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    }

    @Override
    public List<CartItem> getCartItemsFromShoppingCart(Long id) {
        Order o = this.findById(id);
        Long shoppingCartId = o.getShoppingCart().getShoppingCartId();
        return cartItemService.findAllByShoppingCartId(shoppingCartId);
    }

    @Override
    public void placeOrder(Long shoppingCartId, String name, String email, String deliveryAddress, Boolean fastDelivery) {
       //todo fix implementation, figure out the users
        Order order = new Order();
        ShoppingCart sc = shoppingCartService.findById(shoppingCartId);
        User user = sc.getUser();

        int totalPrice = sc.getCartItems().stream().mapToInt(i -> i.getProduct().getPrice() * i.getQuantity()).sum();

        order.setShoppingCart(sc);
        order.setUser(user);
        order.setOrderDate(LocalDate.now());
        order.setPaymentStatus(PAYMENT_STATUS.PAID);
        order.setDeliveryAddress(deliveryAddress);
        order.setFastDelivery(fastDelivery);
        order.setTotalPrice(totalPrice);
        order.setTrackingNumber("");
    }
}
