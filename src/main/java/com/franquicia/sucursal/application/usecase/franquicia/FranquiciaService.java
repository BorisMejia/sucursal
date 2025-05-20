package com.franquicia.sucursal.application.usecase.franquicia;

import com.franquicia.sucursal.domain.model.Franquicia;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FranquiciaService {

    Mono<Franquicia> crearFranquicia(String idFranquicia, String nombreFranquicia);

    Flux<Franquicia> obtenerTodasLasFranquicias();

    Mono<Franquicia> obtenerFranquiciaById(String idFranquicia);

    Mono<Franquicia> agregarSucursal(String idFranquicia, String idSucursal, String nombreSucursal);

    Mono<Franquicia> agregarProducto(String idFranquicia, String idSucursal, String idProducto, String nombreProducto, Integer stock);

    Mono<Franquicia> eliminarProducto(String idFranquicia, String idSucursal, String idProducto);

    Mono<Franquicia> actualizarStockProducto(String idFranquicia, String idSucursal, String idProducto, Integer nuevoStock);

    Flux<String> obtenerProductosConMayorStockPorSucursal(String idFranquicia);

    Mono<Franquicia> actualizarNombreFranquicia(String idFranquicia, String nuevoNombre);

    Mono<Franquicia> actualizarNombreSucursal(String idFranquicia, String idSucursal, String nuevoNombre);

    Mono<Franquicia> actualizarNombreProducto(String idFranquicia, String idSucursal, String idProducto, String nuevoNombre);
}
