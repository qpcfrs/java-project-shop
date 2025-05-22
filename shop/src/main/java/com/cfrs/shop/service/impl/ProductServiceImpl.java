package com.cfrs.shop.service.impl;

import com.cfrs.shop.domain.Product;
import com.cfrs.shop.repository.ProductRepository;
import com.cfrs.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        Product existing = productRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(product.getName());
            existing.setPrice(product.getPrice());
            existing.setDescription(product.getDescription());
            existing.setImageUrl(product.getImageUrl());
            return productRepository.save(existing);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
