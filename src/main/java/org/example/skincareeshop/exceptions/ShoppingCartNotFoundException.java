package org.example.skincareeshop.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class ShoppingCartNotFoundException extends EntityNotFoundException {
    public ShoppingCartNotFoundException(Long id) {
        super("Shopping cart with id " + id + " not found");
    }
}
