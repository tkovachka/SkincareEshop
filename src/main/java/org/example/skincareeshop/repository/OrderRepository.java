package org.example.skincareeshop.repository;

import org.example.skincareeshop.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepository extends JpaRepository<Order, Long> {
}
