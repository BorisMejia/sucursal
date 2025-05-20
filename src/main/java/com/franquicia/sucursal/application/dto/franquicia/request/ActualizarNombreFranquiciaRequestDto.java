package com.franquicia.sucursal.application.dto.franquicia.request;

import jakarta.validation.constraints.NotBlank;

public record ActualizarNombreFranquiciaRequestDto(
        @NotBlank(message = "El nombre de la franquicia no puede estar vacío")
        String nombre
) {
}
