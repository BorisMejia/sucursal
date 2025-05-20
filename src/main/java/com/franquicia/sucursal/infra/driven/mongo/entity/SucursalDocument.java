package com.franquicia.sucursal.infra.driven.mongo.entity;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SucursalDocument {

    private String id;
    private String nombre;
    private List<ProductoDocument> productos;
}
