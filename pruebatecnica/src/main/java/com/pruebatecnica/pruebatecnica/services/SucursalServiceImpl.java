package com.pruebatecnica.pruebatecnica.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.pruebatecnica.entities.Sucursal;
import com.pruebatecnica.pruebatecnica.repositories.SurcursalRepository;

@Service
public class SucursalServiceImpl implements SucursalService {

    @Autowired
    private SurcursalRepository surcursalRepository;

    @Override
    public List<Sucursal> findAll() {
        
        return (List<Sucursal>) surcursalRepository.findAll();
    }

    @Override
    public Sucursal save(Sucursal sucursal) {
        return surcursalRepository.save(sucursal);
    }

    @Override
    public Sucursal updateProductById(Long id, Sucursal sucursal) {
        Optional<Sucursal> optionalSucursal = surcursalRepository.findById(id);
        if (optionalSucursal.isPresent()){
             Sucursal sucursalNuevo = optionalSucursal.get();
             sucursalNuevo.setNombre(sucursal.getNombre());
            return surcursalRepository.save(sucursalNuevo);
        } else {
            return null;
        }
        
    }

    @Override
    public String deleteProductById(Long id) {
        Optional<Sucursal> sucursalOptional = surcursalRepository.findById(id);

        if (sucursalOptional.isPresent()){
            surcursalRepository.delete(sucursalOptional.get());
            return "La sucursal se ha borrado con exito";
        } else {
            return "La sucursal no existe";
        }
        
    }
    
}
