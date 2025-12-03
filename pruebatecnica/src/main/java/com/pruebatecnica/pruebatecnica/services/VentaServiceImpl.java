package com.pruebatecnica.pruebatecnica.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.pruebatecnica.entities.Venta;
import com.pruebatecnica.pruebatecnica.repositories.VentaRepository;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public Venta save(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public List<Venta> buscarPorSucursalYFecha(Long sucursalId, LocalDate fecha) {
                
        LocalDateTime inicio = fecha.atStartOfDay();
        LocalDateTime fin = fecha.plusDays(1).atStartOfDay();

        return ventaRepository.findBySucursalIdAndFechaBetween(sucursalId, inicio, fin);

    }

    @Override
    public String deleteById(Long id) {

        Optional<Venta> venta = ventaRepository.findById(id);
        
        if(venta.isPresent()) {
            ventaRepository.deleteById(id);
            return "Se ha borrado correctamente";
        } else {
            return "La venta no existe";    
        }
    }
    
}
