package com.akhambir.service;

import com.akhambir.model.Product;

import java.util.Optional;

public interface ProductService {
    Optional<Product> getById(Long id);
}
