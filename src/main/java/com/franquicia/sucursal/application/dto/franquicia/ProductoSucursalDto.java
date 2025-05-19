package com.franquicia.sucursal.application.dto.franquicia;

public record ProductoSucursalDto(
        String idProducto,
        String nombreProducto,
        Integer stock,
        String idSucursal,
        String nombreSucursal
) {}
