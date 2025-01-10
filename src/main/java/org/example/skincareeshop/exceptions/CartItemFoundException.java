package org.example.skincareeshop.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class CartItemFoundException extends EntityNotFoundException {
    public CartItemFoundException(Long id) {
        super("Cart item with id " + id + " not found");
    }
}
