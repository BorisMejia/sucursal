package com.franquicia.sucursal.application.dto.franquicia.response;

import java.util.List;

public record SucursalResponseDto(
        String id,
        String nombre,
        List<ProductoResponseDto> productos
)
{}
