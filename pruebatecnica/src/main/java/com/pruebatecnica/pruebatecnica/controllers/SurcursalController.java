package com.pruebatecnica.pruebatecnica.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pruebatecnica.pruebatecnica.services.SucursalService;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pruebatecnica.pruebatecnica.entities.Sucursal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/surcursales")
public class SurcursalController {
    
    @Autowired
    private SucursalService sucursalService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAllSucursales() {

        List<Sucursal> sucursal = sucursalService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(sucursal);

    }

    @PostMapping("/create")
    public ResponseEntity<?> createSucursal(@Valid @RequestBody Sucursal sucursal, BindingResult result) {
        
        if(result.hasFieldErrors()){
            return validation(result);
        } 

        return ResponseEntity.status(HttpStatus.CREATED).body(sucursalService.save(sucursal));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateSucursal(@Valid @PathVariable Long id ,@RequestBody Sucursal sucursal, BindingResult result ) {

        if(result.hasFieldErrors()){
            return validation(result);
        } 
        return ResponseEntity.status(HttpStatus.OK).body(sucursalService.updateProductById(id, sucursal));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSucursal(@PathVariable Long id){
        String resultado = sucursalService.deleteProductById(id);

        return ResponseEntity.status(HttpStatus.OK).body(resultado);
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
