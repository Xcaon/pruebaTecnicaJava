package com.pruebatecnica.pruebatecnica.services;

import java.util.List;

import com.pruebatecnica.pruebatecnica.entities.Product;

public interface ProductService {
    
    List<Product> findAll();

    Product save(Product product);

    Product updateProductById(Long id, Product product);

    Product deleteProductById(Long id);

    List<Object[]> getProductosMasVendidos();

}
