package com.franquicia.sucursal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Sucursal {

    private String id;
    private String nombre;
    private List<Producto> productos;

    public Sucursal(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    public Sucursal(String id, String nombre, List<Producto> productos) {
        this.id = id;
        this.nombre = nombre;
        this.productos = productos;
    }

    public void agregarProducto(Producto nuevo) {
        if (productos.stream().anyMatch(p -> p.getId().equals(nuevo.getId()))) {
            throw new IllegalArgumentException("Ya existe un producto con ID: " + nuevo.getId());
        }
        this.productos.add(nuevo);
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void eliminarProducto(String idProducto) {
        this.productos.removeIf(p -> p.getId().equals(idProducto));
    }

    public Producto obtenerProductoPorId(String idProducto) {
        return this.productos.stream()
                .filter(p -> p.getId().equals(idProducto))
                .findFirst()
                .orElse(null);
    }
    public Sucursal() {
        this.id = null;
        this.nombre = null;
        this.productos = new ArrayList<>();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
