package com.franquicia.sucursal.infra.driven.mongo.mapper;

import com.franquicia.sucursal.domain.model.Franquicia;
import com.franquicia.sucursal.domain.model.Producto;
import com.franquicia.sucursal.domain.model.Sucursal;
import com.franquicia.sucursal.infra.driven.mongo.entity.FranquiciaDocument;
import com.franquicia.sucursal.infra.driven.mongo.entity.ProductoDocument;
import com.franquicia.sucursal.infra.driven.mongo.entity.SucursalDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FranquiciaMapper {

    FranquiciaDocument toDocument(Franquicia franquicia);
    Franquicia toDomain(FranquiciaDocument franquiciaDocument);

    SucursalDocument toDocument(Sucursal sucursal);
    Sucursal toDomain(SucursalDocument sucursalDocument);

    ProductoDocument toDocument(Producto producto);
    Producto toDocument(ProductoDocument productoDocument);

    List<SucursalDocument> toDocumentSucursalesList(List<Sucursal> sucursales);
    List<Sucursal> toDomainSucursalesList(List<SucursalDocument> sucursalDocuments);

    List<ProductoDocument> toDocumentProductosList(List<Producto> productos);
    List<Producto> toDomainProductosList(List<ProductoDocument> productoDocuments);
}
