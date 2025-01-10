package org.example.skincareeshop.service.impl;

import org.example.skincareeshop.exceptions.ShoppingCartNotFoundException;
import org.example.skincareeshop.models.CartItem;
import org.example.skincareeshop.models.Product;
import org.example.skincareeshop.models.ShoppingCart;
import org.example.skincareeshop.models.User;
import org.example.skincareeshop.repository.ShoppingCartRepository;
import org.example.skincareeshop.service.CartItemService;
import org.example.skincareeshop.service.ProductService;
import org.example.skincareeshop.service.ShoppingCartService;
import org.example.skincareeshop.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final UserService userService;
    private final CartItemService cartItemService;
    private final ProductService productService;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, UserService userService, ProductService productService, CartItemService cartItemService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userService = userService;
        this.productService = productService;
        this.cartItemService = cartItemService;
    }

    @Override
    public List<ShoppingCart> findAll() {
        return shoppingCartRepository.findAll();
    }

    @Override
    public ShoppingCart findById(Long id) {
        return shoppingCartRepository.findById(id).orElseThrow(() -> new ShoppingCartNotFoundException(id));
    }

    @Override
    public void emptyShoppingCart(Long id) {
        ShoppingCart sc = this.findById(id);
        sc.getCartItems().clear();
    }

    @Override
    public ShoppingCart findByUserId(Long userId) {
        User u = userService.findById(userId);
        return shoppingCartRepository.findByUserLike(u);
    }

    @Override
    public void addProductToCart(Long userId, Long productId, Integer quantity) {
        ShoppingCart sc = findByUserId(userId);
        CartItem item = new CartItem();
        item.setShoppingCart(sc);
        item.setProduct(productService.findById(productId));
        item.setQuantity(quantity);

        sc.getCartItems().add(item);
    }

    @Override
    public void deleteProductFromCart(Long userId, Long cartItemId) {
        ShoppingCart sc = findByUserId(userId);
        CartItem item = cartItemService.findById(cartItemId);
        sc.getCartItems().remove(item);
    }

    @Override
    public void changeProductQuantity(Long userId, Long productId, Integer newQuantity) {
        //todo implement function
    }

}
