package com.franquicia.sucursal.infra.driven.mongo.adapter;

import com.franquicia.sucursal.domain.model.Franquicia;
import com.franquicia.sucursal.domain.repository.FranquiciaRepository;
import com.franquicia.sucursal.infra.driven.mongo.mapper.FranquiciaMapper;
import com.franquicia.sucursal.infra.driven.mongo.repository.MongoFranquiciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class FranquiciaRepositoryImpl implements FranquiciaRepository {

    private final MongoFranquiciaRepository mongoRepository;
    private final FranquiciaMapper mapper;
    @Override
    public Mono<Franquicia> guardarFranquicia(Franquicia franquicia) {
        return mongoRepository.save(mapper.toDocument(franquicia)).map(mapper::toDomain);
    }

    @Override
    public Mono<Franquicia> buscarFranquiciaById(String id) {
        return mongoRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Flux<Franquicia> buscarTodasFranquicias() {
        return mongoRepository.findAll().map(mapper::toDomain);
    }

    @Override
    public Mono<Void> eliminarFranquicia(String id) {
        return mongoRepository.deleteById(id);
    }

    @Override
    public Mono<Franquicia> updateFranquicia(Franquicia franquicia) {
        return guardarFranquicia(franquicia);
    }
}
