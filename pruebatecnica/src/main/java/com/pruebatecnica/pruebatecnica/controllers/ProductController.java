package com.pruebatecnica.pruebatecnica.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pruebatecnica.pruebatecnica.entities.Product;
import com.pruebatecnica.pruebatecnica.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    
    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> productos = productService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(productos);
    }

    
    @GetMapping("/producto-mas-vendido")
    public ResponseEntity<?> getProductoMasVendido(){
        List<Object[]> productosMasVendidos = productService.getProductosMasVendidos();

        return ResponseEntity.status(HttpStatus.OK).body(productosMasVendidos);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@Valid @RequestBody Product product, BindingResult result) {
        
        if(result.hasFieldErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Se ha creado con exito el producto con ID: " + productService.save(product).getProductoId());
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateProduct(@Valid @PathVariable Long id, @RequestBody Product product, BindingResult result) {
        
        if(result.hasFieldErrors()) {
            return validation(result);
        }

        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProductById(id, product));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){

        return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProductById(id));
    }
    
    // Por cada field que no esta correcto guardamos un mensaje y luego lo mostramos
    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });

        // Devolvemos en el JSON los errores
        return ResponseEntity.badRequest().body(errors);
    }

}
