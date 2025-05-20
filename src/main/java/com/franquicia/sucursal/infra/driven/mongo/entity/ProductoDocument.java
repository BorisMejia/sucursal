package com.franquicia.sucursal.infra.driven.mongo.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDocument {

    private String id;
    private String nombreProducto;
    private Integer stock;
}
