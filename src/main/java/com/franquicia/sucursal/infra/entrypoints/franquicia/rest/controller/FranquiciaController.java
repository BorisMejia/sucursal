package com.franquicia.sucursal.infra.entrypoints.franquicia.rest.controller;

import com.franquicia.sucursal.application.dto.franquicia.mapper.FranquiciaDtoMapper;
import com.franquicia.sucursal.application.dto.franquicia.request.*;
import com.franquicia.sucursal.application.dto.franquicia.response.FranquiciaResponseDto;
import com.franquicia.sucursal.application.usecase.franquicia.FranquiciaService;
import com.franquicia.sucursal.domain.model.Franquicia;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/franquicias", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class FranquiciaController {

    private final FranquiciaService franquiciaService;
    private final FranquiciaDtoMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<FranquiciaResponseDto> crearFranquicia(@Valid @RequestBody FranquiciaRequestDto dto) {
        return franquiciaService.crearFranquicia(dto.id(), dto.nombre())
                .map(mapper::toDto);
    }

    @GetMapping
    public Flux<FranquiciaResponseDto> listarFranquicias() {
        return franquiciaService.obtenerTodasLasFranquicias()
                .map(mapper::toDto);
    }

    @PostMapping("/{idFranquicia}/sucursales")
    public Mono<FranquiciaResponseDto> agregarSucursal(
            @PathVariable String idFranquicia,
            @Valid @RequestBody SucursalRequestDto dto) {
        return franquiciaService.agregarSucursal(idFranquicia, dto.id(), dto.nombre())
                .map(mapper::toDto);
    }

    @PutMapping("/{idFranquicia}/nombre")
    public Mono<FranquiciaResponseDto> actualizarNombreFranquicia(
            @PathVariable String idFranquicia,
            @RequestBody @Valid ActualizarNombreFranquiciaRequestDto dto) {
        return franquiciaService.actualizarNombreFranquicia(idFranquicia, dto.nombre())
                .map(mapper::toDto);
    }

    @PutMapping("/{idFranquicia}/sucursales/{idSucursal}/nombre")
    public Mono<FranquiciaResponseDto> actualizarNombreSucursal(
            @PathVariable String idFranquicia,
            @PathVariable String idSucursal,
            @RequestBody @Valid ActualizarNombreSucursalDto dto) {
        return franquiciaService.actualizarNombreSucursal(idFranquicia, idSucursal, dto.nombre())
                .map(mapper::toDto);
    }

    @PostMapping("/{idFranquicia}/sucursales/{idSucursal}/productos")
    public Mono<FranquiciaResponseDto> agregarProducto(
            @PathVariable String idFranquicia,
            @PathVariable String idSucursal,
            @Valid @RequestBody ProductoRequestDto dto) {
        return franquiciaService.agregarProducto(idFranquicia, idSucursal, dto.id(), dto.nombreProducto(), dto.stock())
                .map(mapper::toDto);
    }

    @PutMapping("/{idFranquicia}/sucursales/{idSucursal}/productos/{idProducto}/nombre")
    public Mono<FranquiciaResponseDto> actualizarNombreProducto(
            @PathVariable String idFranquicia,
            @PathVariable String idSucursal,
            @PathVariable String idProducto,
            @RequestBody @Valid ActualizarNombreProductoRequestDto request) {
        return franquiciaService
                .actualizarNombreProducto(idFranquicia, idSucursal, idProducto, request.nombreProducto())
                .map(mapper::toDto);
    }

    @PutMapping("/{idFranquicia}/sucursales/{idSucursal}/productos/{idProducto}/stock")
    public Mono<FranquiciaResponseDto> actualizarStockProducto(
            @PathVariable String idFranquicia,
            @PathVariable String idSucursal,
            @PathVariable String idProducto,
            @RequestBody @Valid ActualizarStockRequestDto request) {
        return franquiciaService
                .actualizarStockProducto(idFranquicia, idSucursal, idProducto, request.stock())
                .map(mapper::toDto);
    }

    @DeleteMapping("/{idFranquicia}/sucursales/{idSucursal}/productos/{idProducto}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> eliminarProducto(
            @PathVariable String idFranquicia,
            @PathVariable String idSucursal,
            @PathVariable String idProducto) {
        return franquiciaService.eliminarProducto(idFranquicia, idSucursal, idProducto).then();
    }

    @GetMapping("/{idFranquicia}/productos-mayor-stock")
    public Flux<String> obtenerProductosMayorStockPorSucursal(@PathVariable String idFranquicia) {
        return franquiciaService.obtenerProductosConMayorStockPorSucursal(idFranquicia);
    }
}
