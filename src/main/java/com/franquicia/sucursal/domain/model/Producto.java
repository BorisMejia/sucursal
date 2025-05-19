package com.franquicia.sucursal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    private String id = UUID.randomUUID().toString();
    private String nombreProducto;

    private Integer stock;
}
