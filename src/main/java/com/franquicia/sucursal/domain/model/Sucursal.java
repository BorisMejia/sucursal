package com.franquicia.sucursal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Sucursal {

    private final String id;
    private String nombre;
    private final List<Producto> productos;

    public Sucursal(String nombre) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    public Sucursal(String id, String nombre, List<Producto> productos) {
        this.id = id;
        this.nombre = nombre;
        this.productos = productos;
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

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
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
}
