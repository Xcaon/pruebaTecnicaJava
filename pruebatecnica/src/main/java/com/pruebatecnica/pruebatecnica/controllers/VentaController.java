package com.pruebatecnica.pruebatecnica.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pruebatecnica.pruebatecnica.entities.Venta;
import com.pruebatecnica.pruebatecnica.services.VentaService;

import jakarta.websocket.server.PathParam;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/ventas")
public class VentaController {
    

    @Autowired
    private VentaService ventaService;

    // Esta ruta debe estar protegida y solo accesible para usuarios con rol ADMIN
    @PostMapping("/create")
    public ResponseEntity<?> createVenta(@RequestBody Venta venta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.save(venta));
    }

    // Tendra que buscar /api/ventas?sucursalId=1&fecha=2023-10-10
    @GetMapping("/getBySucursalAndDate")
    public ResponseEntity<?> getVentasByDate(@RequestParam Long sucursalId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return ResponseEntity.status(HttpStatus.OK).body(ventaService.buscarPorSucursalYFecha(sucursalId, fecha));
        
    }


    // Esta ruta debe estar protegida y solo accesible para usuarios con rol ADMIN
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
         return ventaService.deleteById(id);
    }

    

}
