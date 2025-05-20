package com.franquicia.sucursal.application.dto.franquicia.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ProductoRequestDto(
        @NotBlank(message = "El ID del producto es obligatorio")
        String id,
        @NotBlank(message = "El nombre del producto es obligatorio")
         String nombreProducto,
         @Min(value = 0, message = "El stock no puede ser negativo")
         int stock
)
{}
