package com.franquicia.sucursal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Franquicia {

    private String id;

    private String nombreFranquicia;

    private List<Sucursal> sucursales;
}
