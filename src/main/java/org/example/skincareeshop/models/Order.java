package org.example.skincareeshop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.skincareeshop.models.enums.PAYMENT_STATUS;

import java.time.LocalDate;

@Entity
@Table(name = "eshop_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;
    private Integer totalPrice;
    private LocalDate orderDate;
    private String deliveryAddress;
    private Boolean fastDelivery;

    @Enumerated(EnumType.STRING)
    private PAYMENT_STATUS paymentStatus;
    private String trackingNumber;


}
