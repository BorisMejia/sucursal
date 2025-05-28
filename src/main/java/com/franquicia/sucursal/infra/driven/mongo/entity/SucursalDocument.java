package com.franquicia.sucursal.infra.driven.mongo.entity;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SucursalDocument {

    private String id;
    private String nombre;
    private List<ProductoDocument> productos;

}
