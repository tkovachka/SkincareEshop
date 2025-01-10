package org.example.skincareeshop.models;

import jakarta.persistence.*;
import lombok.Data;
import org.example.skincareeshop.models.enums.SKIN_TYPE;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "eshop_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String email;
    private String passwordHash;
    private LocalDate registrationDate;
    @Enumerated(EnumType.STRING)
    private SKIN_TYPE skinType;
    private Integer loyaltyPointsEarned;
    private Integer loyaltyPointsUsed;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;

}
