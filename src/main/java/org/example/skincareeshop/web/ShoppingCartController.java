package org.example.skincareeshop.web;

import org.example.skincareeshop.models.ShoppingCart;
import org.example.skincareeshop.service.ProductService;
import org.example.skincareeshop.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart/{userId}")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;

    public ShoppingCartController(ShoppingCartService shoppingCartService, ProductService productService) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
    }

    @GetMapping
    public String getCart(@PathVariable Long userId, Model model){
        ShoppingCart cart = shoppingCartService.findByUserId(userId);
        model.addAttribute("cartItems", cart.getCartItems());
        model.addAttribute("totalPrice", cart.getTotalPrice());
        model.addAttribute("recommendedProducts", productService.findRecommendedProducts(userId));
        return "shoppingCart";
    }

    @PostMapping("/add-to-cart/{productId}")
    public String addProductToCart(@PathVariable Long userId,
                                   @PathVariable Long productId,
                                   @RequestParam Integer quantity) {
        shoppingCartService.addProductToCart(userId, productId, quantity);
        return "redirect:/cart/"+userId;
    }

}
