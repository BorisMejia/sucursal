package com.franquicia.sucursal.infra.driven.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDocument {
    private String idProducto;
    private String nombreProcuto;
    private Integer stock;
}
