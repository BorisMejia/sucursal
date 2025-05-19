package com.franquicia.sucursal.application.service.franquicia;

import com.franquicia.sucursal.application.dto.franquicia.ProductoSucursalDto;
import com.franquicia.sucursal.application.usecase.franquicia.FranquiciaService;
import com.franquicia.sucursal.domain.model.Franquicia;
import com.franquicia.sucursal.domain.model.Producto;
import com.franquicia.sucursal.domain.model.Sucursal;
import com.franquicia.sucursal.domain.repository.FranquiciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FranquiciaServiceImpl implements FranquiciaService {

    private final FranquiciaRepository franquiciaRepository;
    @Override
    public Mono<Franquicia> crearFranquicia(Franquicia franquicia) {
        return null;
    }

    @Override
    public Mono<Franquicia> agregarSucursal(String idFranquicia, Sucursal sucursal) {
        return null;
    }

    @Override
    public Mono<Franquicia> agregarProducto(String idFranquicia, Producto producto) {
        return null;
    }

    @Override
    public Mono<Franquicia> eliminarProducto(String idFranquicia, String idSucursal, String idProducto) {
        return null;
    }

    @Override
    public Mono<Franquicia> modificarStockProducto(String idFranquicia, String idSucursal, String idProducto, Integer newStock) {
        return null;
    }

    @Override
    public Flux<ProductoSucursalDto> obtenerProductosConMasStockSucursal(String idFranquicia) {
        return null;
    }

    @Override
    public Mono<Franquicia> obtenerFranquiciaById(String idFranquicia) {
        return null;
    }

    @Override
    public Flux<Franquicia> obtenerTodasFranquicias() {
        return null;
    }

    @Override
    public Mono<Void> eliminarFranquicia(String idFranquicia) {
        return null;
    }
}
