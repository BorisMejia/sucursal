package com.franquicia.sucursal.infra.entrypoints.franquicia.handler;

import com.franquicia.sucursal.application.usecase.franquicia.FranquiciaService;
import com.franquicia.sucursal.domain.model.Franquicia;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
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
}
