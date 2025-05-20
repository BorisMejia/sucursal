package com.franquicia.sucursal.infra.driven.mongo.repository;

import com.franquicia.sucursal.infra.driven.mongo.entity.FranquiciaDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface MongoFranquiciaRepository extends ReactiveMongoRepository<FranquiciaDocument, String> {
}
