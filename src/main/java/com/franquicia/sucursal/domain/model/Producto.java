package com.franquicia.sucursal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

public class Producto {

    private String id;
    private String nombreProducto;
    private int stock;

    public Producto(String id, String nombreProducto, int stock) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public Producto() {
        this.id = null;
        this.nombreProducto = null;
        this.stock = 0;
    }

    public void setId(String id) {
        this.id = id;
    }
}
