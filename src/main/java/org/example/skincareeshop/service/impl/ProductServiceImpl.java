package org.example.skincareeshop.service.impl;

import org.example.skincareeshop.exceptions.ProductNotFoundException;
import org.example.skincareeshop.models.Product;
import org.example.skincareeshop.models.User;
import org.example.skincareeshop.models.enums.PRODUCT_TYPE;
import org.example.skincareeshop.models.enums.SKIN_TYPE;
import org.example.skincareeshop.repository.ProductRepository;
import org.example.skincareeshop.service.ProductService;
import org.example.skincareeshop.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final UserService userService;

    public ProductServiceImpl(ProductRepository productRepository, UserService userService) {
        this.productRepository = productRepository;
        this.userService = userService;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public List<Product> findByProductType(PRODUCT_TYPE productType) {
        return productRepository.findAllByProductTypeLike(productType);
    }

    @Override
    public List<Product> findBySkinType(SKIN_TYPE skinType) {
        return productRepository.findAllBySkinTypeLike(skinType);
    }

    @Override
    public List<Product> findRecommendedProducts(Product product) {
        return productRepository.findAllBySkinTypeLikeAndProductTypeLike(product.getSkinType(), product.getProductType());
    }

    @Override
    public List<Product> findRecommendedProducts(Long userId) {
        //todo fix implementation
        User user = userService.findById(userId);
        if (user.getSkinType() != null)
            return productRepository.findAllBySkinTypeLike(user.getSkinType());
        return productRepository.findAllBySkinTypeLike(SKIN_TYPE.COMBINED);
    }
}
