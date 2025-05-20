package com.franquicia.sucursal.application.dto.franquicia.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ActualizarStockRequestDto(
        @NotNull
        @Min(0)
        Integer stock
) {
}
