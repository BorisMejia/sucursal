package com.franquicia.sucursal.infra.driven.mongo.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductoDocument {

    private String id;
    private String nombreProducto;
    private Integer stock;
}
