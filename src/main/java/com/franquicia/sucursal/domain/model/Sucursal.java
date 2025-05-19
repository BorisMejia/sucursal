package com.franquicia.sucursal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sucursal {

    private String id = UUID.randomUUID().toString();
    private String nombreSucursal;
    private List<Producto> productos;
}
