package com.franquicia.sucursal.infra.entrypoints.franquicia.handler;

import com.franquicia.sucursal.application.dto.franquicia.ProductoSucursalDto;
import com.franquicia.sucursal.application.usecase.franquicia.FranquiciaService;
import com.franquicia.sucursal.domain.model.Franquicia;
import com.franquicia.sucursal.domain.model.Producto;
import com.franquicia.sucursal.domain.model.Sucursal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FranquiciaHandler {

    private final FranquiciaService franquiciaService;

    public Mono<ServerResponse> crearFranquicia(ServerRequest request){
        return request.bodyToMono(Franquicia.class)
                .flatMap(franquiciaService::crearFranquicia)
                .flatMap(result -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));
    }
    public Mono<ServerResponse> agregarSucursal(ServerRequest request){
        String idFranquicia = request.pathVariable("idFranquicia");
        return request.bodyToMono(Sucursal.class)
                .flatMap(sucursal -> franquiciaService.agregarSucursal(idFranquicia, sucursal))
                .flatMap(result -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));
    }
    public Mono<ServerResponse> agregarProducto(ServerRequest request){
        String idFranquicia = request.pathVariable("idFranquicia");
        String idSucursal = request.pathVariable("idSucursal");

        return request.bodyToMono(Producto.class)
                .flatMap(producto -> franquiciaService.agregarProducto(idFranquicia, idSucursal, producto))
                .flatMap(result -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));
    }
    public Mono<ServerResponse> eliminarProducto(ServerRequest request){
        String idFraquicia = request.pathVariable("idFranquicia");
        String idSucursal = request.pathVariable("idSucursal");
        String idProducto = request.pathVariable("idProducto");
        return franquiciaService.eliminarProducto(idFraquicia,idSucursal, idProducto)
                .then(ServerResponse.noContent().build());
    }
    public Mono<ServerResponse> modificarStock(ServerRequest request){
        String idFraquicia = request.pathVariable("idFranquicia");
        String idSucursal = request.pathVariable("idSucursal");
        String idProducto = request.pathVariable("idProducto");
        return request.bodyToMono(Integer.class)
                .flatMap(newStock -> franquiciaService.modificarStockProducto(idFraquicia,idSucursal,idProducto, newStock))
                .flatMap(updateStock -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(updateStock));
    }
    public Mono<ServerResponse> obtenerProductosConMayorStock(ServerRequest request){
        String idSucursal = request.pathVariable("idSucursal");
        return ServerResponse.ok()
                .body(franquiciaService.obtenerProductosConMasStockSucursal(idSucursal), ProductoSucursalDto.class);
    }



}
