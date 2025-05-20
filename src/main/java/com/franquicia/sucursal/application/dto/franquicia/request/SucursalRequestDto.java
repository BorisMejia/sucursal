package com.franquicia.sucursal.application.dto.franquicia.request;

import jakarta.validation.constraints.NotBlank;

public record SucursalRequestDto(
        @NotBlank(message = "El ID de la sucursal es obligatorio")
        String id,
        @NotBlank(message = "El nombre de la sucursal es obligatorio")
        String nombre
)
{}
