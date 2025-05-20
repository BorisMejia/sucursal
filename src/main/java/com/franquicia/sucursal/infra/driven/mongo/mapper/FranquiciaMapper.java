package com.franquicia.sucursal.infra.driven.mongo.mapper;

import com.franquicia.sucursal.domain.model.Franquicia;
import com.franquicia.sucursal.domain.model.Producto;
import com.franquicia.sucursal.domain.model.Sucursal;
import com.franquicia.sucursal.infra.driven.mongo.entity.FranquiciaDocument;
import com.franquicia.sucursal.infra.driven.mongo.entity.ProductoDocument;
import com.franquicia.sucursal.infra.driven.mongo.entity.SucursalDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FranquiciaMapper {
    FranquiciaMapper INSTANCE = Mappers.getMapper(FranquiciaMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "sucursales", target = "sucursales")
    })
    FranquiciaDocument toDocument(Franquicia franquicia);
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "sucursales", target = "sucursales")
    })
    Franquicia toDomain(FranquiciaDocument document);


    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "productos", target = "productos")
    })
    SucursalDocument toDocument(Sucursal sucursal);
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "productos", target = "productos")
    })
    Sucursal toDomain(SucursalDocument document);


    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombreProducto", target = "nombreProducto"),
            @Mapping(source = "stock", target = "stock")
    })
    ProductoDocument toDocument(Producto producto);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombreProducto", target = "nombreProducto"),
            @Mapping(source = "stock", target = "stock")
    })
    Producto toDomain(ProductoDocument document);

    List<Franquicia> toDomainList(List<FranquiciaDocument> documents);
    List<FranquiciaDocument> toDocumentList(List<Franquicia> models);
}
