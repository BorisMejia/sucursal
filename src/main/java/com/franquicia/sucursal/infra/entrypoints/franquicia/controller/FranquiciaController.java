package com.franquicia.sucursal.infra.entrypoints.franquicia.controller;

import com.franquicia.sucursal.application.usecase.franquicia.FranquiciaService;
import com.franquicia.sucursal.domain.model.Franquicia;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/franquicias", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class FranquiciaController {

    private final FranquiciaService franquiciaService;

    @GetMapping("/")
    public Mono<String> ping(){
        return Mono.just("Conectado...");
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Franquicia> crearFranquicia(@RequestBody Franquicia franquicia){
        return franquiciaService.crearFranquicia(franquicia);
    }
}
