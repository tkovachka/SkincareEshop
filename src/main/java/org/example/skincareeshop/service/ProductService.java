package org.example.skincareeshop.service;

import org.example.skincareeshop.models.Product;
import org.example.skincareeshop.models.enums.PRODUCT_TYPE;
import org.example.skincareeshop.models.enums.SKIN_TYPE;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Long id);

    List<Product> findByProductType(PRODUCT_TYPE productType);

    List<Product> findBySkinType(SKIN_TYPE skinType);

    List<Product> findRecommendedProducts(Product product);
    List<Product> findRecommendedProducts(Long userId);
}
