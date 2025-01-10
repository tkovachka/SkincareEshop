package org.example.skincareeshop.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class OrderNotFoundException extends EntityNotFoundException {
    public OrderNotFoundException(Long id) {
        super("Order with id " + id + " not found");
    }
}
