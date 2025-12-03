package com.pruebatecnica.pruebatecnica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pruebatecnica.pruebatecnica.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
    


    // Nos devuelve una lista de Object[] donde en la posicion 0 esta el producto y en la posicion 1 el numero de ventas
    @Query("""
        SELECT p, COUNT(v)
        FROM Product p
        JOIN p.ventas v
        GROUP BY p
        ORDER BY COUNT(v) DESC LIMIT 1
    """)
    List<Object[]> findProductosMasVendidosJPQL();

}
