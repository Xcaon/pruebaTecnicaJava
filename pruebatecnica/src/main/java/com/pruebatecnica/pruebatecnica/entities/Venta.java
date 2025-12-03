package com.pruebatecnica.pruebatecnica.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fecha; 

    @ManyToOne
    @JsonIgnoreProperties({"ventas", "handler", "hibernateLazyInitializer"})
    private Sucursal sucursal;

    @ManyToMany
    @JsonIgnoreProperties({"ventas"})
    private List<Product> products;

    public Venta() {
    }

    public Venta(Long id, Sucursal sucursal) {
        this.id = id;
        this.fecha = LocalDateTime.now();
        this.sucursal = sucursal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }


    public List<Product> getProduct() {
        return products;
    }


    public void setProduct(List<Product> products) {
        this.products = products;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    
    
}
