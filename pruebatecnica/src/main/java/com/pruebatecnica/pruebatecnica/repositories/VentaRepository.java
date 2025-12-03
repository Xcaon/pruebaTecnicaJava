package com.pruebatecnica.pruebatecnica.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pruebatecnica.pruebatecnica.entities.Venta;

public interface VentaRepository extends CrudRepository<Venta, Long> {
    
    List<Venta> findBySucursalIdAndFechaBetween(Long sucursalId, java.time.LocalDateTime inicio, java.time.LocalDateTime fin);

}
