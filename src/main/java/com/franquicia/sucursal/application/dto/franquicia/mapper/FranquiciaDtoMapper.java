package com.franquicia.sucursal.application.dto.franquicia.mapper;

import com.franquicia.sucursal.application.dto.franquicia.response.FranquiciaResponseDto;
import com.franquicia.sucursal.application.dto.franquicia.response.ProductoResponseDto;
import com.franquicia.sucursal.application.dto.franquicia.response.SucursalResponseDto;
import com.franquicia.sucursal.domain.model.Franquicia;
import com.franquicia.sucursal.domain.model.Producto;
import com.franquicia.sucursal.domain.model.Sucursal;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FranquiciaDtoMapper {

    FranquiciaResponseDto toDto(Franquicia franquicia);

    SucursalResponseDto toDto(Sucursal sucursal);

    ProductoResponseDto toDto(Producto producto);

    List<FranquiciaResponseDto> toDtoList(List<Franquicia> franquicias);
}
