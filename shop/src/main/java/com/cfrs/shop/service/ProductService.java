package com.cfrs.shop.service;

import com.cfrs.shop.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product save(Product product);
    Product update(Long id, Product product);
    void delete(Long id);
}
