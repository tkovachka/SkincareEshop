package org.example.skincareeshop.web;

import org.example.skincareeshop.service.OrderService;
import org.example.skincareeshop.service.impl.ShoppingCartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("/order/{shoppingCartId}")
public class OrderController {
    private final OrderService orderService;
    private final ShoppingCartServiceImpl shoppingCartService;

    public OrderController(OrderService orderService, ShoppingCartServiceImpl shoppingCartService) {
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    public String checkoutPage(@PathVariable Long shoppingCartId, Model model) {
        model.addAttribute("shoppingCart", shoppingCartService.findById(shoppingCartId));
        return "order";
    }

    @PostMapping("/place-order")
    public String placeOrder(@PathVariable Long shoppingCartId,
                             @RequestParam String name,
                             @RequestParam String email,
                             @RequestParam String deliveryAddress,
                             @RequestParam Boolean fastDelivery,
                             Model model) {
        orderService.placeOrder(shoppingCartId, name, email, deliveryAddress, fastDelivery);
        shoppingCartService.emptyShoppingCart(shoppingCartId);
        model.addAttribute("shoppingCartId", shoppingCartId);
        return "redirect:/order-confirmation";
    }

    @GetMapping("/order-confirmation")
    String orderConfirmation(@PathVariable Long shoppingCartId, Model model) {
        shoppingCartService.emptyShoppingCart(shoppingCartId);
        model.addAttribute("shoppingCartId", shoppingCartId);
        return "orderConfirmation";
    }


}
