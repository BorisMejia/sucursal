package com.franquicia.sucursal.application.dto.franquicia.request;

import jakarta.validation.constraints.NotBlank;

public record ActualizarNombreSucursalDto(
        @NotBlank(message = "El nombre de la sucursal no puede estar vacío")
        String nombre
) {
}
