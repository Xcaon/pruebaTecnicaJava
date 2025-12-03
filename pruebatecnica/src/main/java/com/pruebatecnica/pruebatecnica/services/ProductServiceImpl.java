package com.pruebatecnica.pruebatecnica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebatecnica.pruebatecnica.entities.Product;
import com.pruebatecnica.pruebatecnica.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProductById(Long id, Product product) {
        Optional<Product> existingProductOptional = productRepository.findById(id);
        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();
            existingProduct.setNombre(product.getNombre());
            existingProduct.setPrecio(product.getPrecio());
            existingProduct.setCategoria(product.getCategoria());
            return productRepository.save(existingProduct);
        } else {
            // Manejar el caso en que el producto no existe (puede lanzar una excepción o devolver null)
            return null;
        }
    }

    @Override
    public Product deleteProductById(Long id) {
        Optional<Product> existingProductOptional = productRepository.findById(id);

        existingProductOptional.ifPresent(product -> productRepository.delete(product));
        return existingProductOptional.orElse(null);
    }

    @Override
    public List<Object[]> getProductosMasVendidos() {
        
        return productRepository.findProductosMasVendidosJPQL();

    }
    
}
