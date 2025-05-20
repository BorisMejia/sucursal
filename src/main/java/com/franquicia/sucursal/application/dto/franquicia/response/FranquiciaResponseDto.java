package com.franquicia.sucursal.application.dto.franquicia.response;

import java.util.List;

public record FranquiciaResponseDto(
        String id,
        String nombre,
        List<SucursalResponseDto> sucursales
)
{}
