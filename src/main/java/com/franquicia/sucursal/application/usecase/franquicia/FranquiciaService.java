package com.franquicia.sucursal.application.usecase.franquicia;

import com.franquicia.sucursal.application.dto.franquicia.ProductoSucursalDto;
import com.franquicia.sucursal.domain.model.Franquicia;
import com.franquicia.sucursal.domain.model.Producto;
import com.franquicia.sucursal.domain.model.Sucursal;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FranquiciaService {

    Mono<Franquicia> crearFranquicia(Franquicia franquicia);

    Mono<Franquicia> agregarSucursal(String idFranquicia, Sucursal sucursal);

    Mono<Franquicia> agregarProducto(String idFranquicia, Producto producto);
    Mono<Franquicia> eliminarProducto(String idFranquicia,String idSucursal, String idProducto);

    Mono<Franquicia> modificarStockProducto(String idFranquicia, String idSucursal, String idProducto, Integer newStock);

    Flux<ProductoSucursalDto> obtenerProductosConMasStockSucursal(String idFranquicia);

    Mono<Franquicia> obtenerFranquiciaById(String idFranquicia);

    Flux<Franquicia> obtenerTodasFranquicias();
    Mono<Void> eliminarFranquicia(String idFranquicia);
}
