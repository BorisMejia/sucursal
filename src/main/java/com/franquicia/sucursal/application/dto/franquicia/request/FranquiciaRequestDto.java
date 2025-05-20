package com.franquicia.sucursal.application.dto.franquicia.request;

import jakarta.validation.constraints.NotBlank;

public record FranquiciaRequestDto(
        @NotBlank(message = "El ID de la franquicia es obligatorio")
        String id,
        @NotBlank(message = "El nombre de la franquicia es obligatorio")
         String nombre
)
{}
