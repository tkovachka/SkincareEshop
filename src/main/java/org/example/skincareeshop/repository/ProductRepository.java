package org.example.skincareeshop.repository;

import org.example.skincareeshop.models.Product;
import org.example.skincareeshop.models.enums.PRODUCT_TYPE;
import org.example.skincareeshop.models.enums.SKIN_TYPE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByProductTypeLike(PRODUCT_TYPE productType);

    List<Product> findAllBySkinTypeLike(SKIN_TYPE skinType);

    List<Product> findAllBySkinTypeLikeAndProductTypeLike(SKIN_TYPE skinType, PRODUCT_TYPE productType);
}
