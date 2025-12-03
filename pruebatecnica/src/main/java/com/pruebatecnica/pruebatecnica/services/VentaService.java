package com.pruebatecnica.pruebatecnica.services;

import java.time.LocalDate;
import java.util.List;

import com.pruebatecnica.pruebatecnica.entities.Venta;

public interface VentaService {
    
    Venta save(Venta venta);

    List<Venta> buscarPorSucursalYFecha(Long sucursalId, LocalDate fecha);

    String deleteById(Long id);

}
