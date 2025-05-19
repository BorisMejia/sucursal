package com.franquicia.sucursal.infra.driven.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SucursalDocument {
    private String idSucursal;
    private String nombreSucursal;
    private List<ProductoDocument> productos;
}
