package com.franquicia.sucursal.domain.repository;

import com.franquicia.sucursal.domain.model.Franquicia;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FranquiciaRepository {

    Mono<Franquicia> guardarFranquicia(Franquicia franquicia);

    Mono<Franquicia> buscarFranquiciaById(String id);

    Flux<Franquicia> buscarTodasFranquicias();

    Mono<Void> eliminarFranquicia(String id);

    Mono<Franquicia> updateFranquicia(Franquicia franquicia);
}
