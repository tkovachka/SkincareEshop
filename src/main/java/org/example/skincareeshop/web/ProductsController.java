package org.example.skincareeshop.web;

import org.example.skincareeshop.models.Product;
import org.example.skincareeshop.models.ShoppingCart;
import org.example.skincareeshop.service.ProductService;
import org.example.skincareeshop.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private final ProductService productService;
    private final ShoppingCartService shoppingCartService;

    public ProductsController(ProductService productService, ShoppingCartService shoppingCartService) {
        this.productService = productService;
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/product/{id}")
    public String getProductDetails(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        List<Product> recommendedProducts = productService.findRecommendedProducts(product);
        model.addAttribute("product", product);
        model.addAttribute("recommendedProducts", recommendedProducts);
        //todo fix getting user after registration and login
        long userId = 1;
        model.addAttribute("userId", userId);
        ShoppingCart sc = shoppingCartService.findByUserId(userId);
        model.addAttribute("shoppingCartId", sc.getShoppingCartId());
        return "details";
    }

}
