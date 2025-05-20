package com.franquicia.sucursal.infra.entrypoints.franquicia.router;

import com.franquicia.sucursal.infra.entrypoints.franquicia.handler.FranquiciaHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class FranquiciaRouter {

    @Bean
    public RouterFunction<ServerResponse> routeFranquicia(FranquiciaHandler handler){
        return RouterFunctions.nest(path("/franquicias"),
                RouterFunctions.route(POST(""), handler::crearFranquicia)
                .andRoute(POST("/{idFranquicia}/sucursales"), handler::agregarSucursal)
                .andRoute(POST("/sucursales/{idSucursal}/productos"), handler::agregarProducto)
                .andRoute(DELETE("/sucursales/{idSucursal}/productos/{idProducto}"),handler::eliminarProducto)
                .andRoute(PUT("/sucursales/{idSucursal}/productos/{idProducto}/stock"), handler::modificarStock)
                .andRoute(GET("/sucursales/{idSucursal}/productos/mayor-stock"), handler::obtenerProductosConMayorStock));
    }
}
