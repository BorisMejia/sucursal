package com.franquicia.sucursal.infra.entrypoints.franquicia.router;

import com.franquicia.sucursal.infra.entrypoints.franquicia.handler.FranquiciaHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;


@Configuration
public class FranquiciaRouter {

    @Bean
    public RouterFunction<ServerResponse> routeFranquicia(FranquiciaHandler handler){
        return RouterFunctions
                .nest(path("/franquicias"),
                RouterFunctions.route(POST("/"), handler::crearFranquicia)
        );
    }
}
