package com.franquicia.sucursal.infra.driven.mongo.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class ProductoDocument {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    private String nombreProducto;
    private Integer stock;
}
