package com.pruebatecnica.pruebatecnica.services;

import java.util.List;

import com.pruebatecnica.pruebatecnica.entities.Sucursal;

public interface SucursalService {
    
    List<Sucursal> findAll();

    Sucursal save(Sucursal product);

    Sucursal updateProductById(Long id, Sucursal sucursal);

    String deleteProductById(Long id);

}
