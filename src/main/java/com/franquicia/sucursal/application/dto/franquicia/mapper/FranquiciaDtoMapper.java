package com.franquicia.sucursal.application.dto.franquicia.mapper;

import com.franquicia.sucursal.application.dto.franquicia.response.FranquiciaResponseDto;
import com.franquicia.sucursal.application.dto.franquicia.response.ProductoResponseDto;
import com.franquicia.sucursal.application.dto.franquicia.response.SucursalResponseDto;
import com.franquicia.sucursal.domain.model.Franquicia;
import com.franquicia.sucursal.domain.model.Producto;
import com.franquicia.sucursal.domain.model.Sucursal;
import com.franquicia.sucursal.infra.driven.mongo.mapper.FranquiciaMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FranquiciaDtoMapper {

    FranquiciaDtoMapper INSTANCE = Mappers.getMapper(FranquiciaDtoMapper.class);

    FranquiciaResponseDto toDto(Franquicia franquicia);

    SucursalResponseDto toDto(Sucursal sucursal);

    ProductoResponseDto toDto(Producto producto);

    List<FranquiciaResponseDto> toDtoList(List<Franquicia> franquicias);
}
