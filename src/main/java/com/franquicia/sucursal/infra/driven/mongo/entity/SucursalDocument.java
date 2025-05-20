package com.franquicia.sucursal.infra.driven.mongo.entity;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class SucursalDocument {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ProductoDocument> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoDocument> productos) {
        this.productos = productos;
    }

    private String id;
    private String nombre;
    private List<ProductoDocument> productos;

}
