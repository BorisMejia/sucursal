package com.franquicia.sucursal.application.dto.franquicia.request;

import jakarta.validation.constraints.NotBlank;

public record ActualizarNombreProductoRequestDto(
        @NotBlank(message = "El nombre del producto no puede estar vacío")
        String nombreProducto
) {
}
