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

import java.util.Comparator;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FranquiciaServiceImpl implements FranquiciaService {

    private final FranquiciaRepository franquiciaRepository;

    @Override
    public Mono<Franquicia> crearFranquicia(String idFranquicia, String nombreFranquicia) {
        return franquiciaRepository.buscarFranquiciaById(idFranquicia)
                .flatMap(existing -> Mono.<Franquicia>error(new IllegalArgumentException("Ya existe una franquicia con el ID: " + idFranquicia)))
                .switchIfEmpty(franquiciaRepository.guardarFranquicia(new Franquicia(idFranquicia, nombreFranquicia)));
    }

    @Override
    public Flux<Franquicia> obtenerTodasLasFranquicias() {
        return franquiciaRepository.buscarTodasFranquicias();
    }

    @Override
    public Mono<Franquicia> obtenerFranquiciaPorId(String idFranquicia) {
        return franquiciaRepository.buscarFranquiciaById(idFranquicia);
    }

    @Override
    public Mono<Franquicia> agregarSucursal(String idFranquicia, String idSucursal, String nombreSucursal) {
        return franquiciaRepository.buscarFranquiciaById(idFranquicia)
                .map(franquicia -> {
                    franquicia.agregarSucursal(new Sucursal(idSucursal, nombreSucursal));
                    return franquicia;
                })
                .flatMap(franquiciaRepository::guardarFranquicia);
    }

    @Override
    public Mono<Franquicia> agregarProducto(String idFranquicia, String idSucursal, String idProducto, String nombreProducto, Integer stock) {
        return franquiciaRepository.buscarFranquiciaById(idFranquicia)
                .map(franquicia -> {
                    Sucursal sucursal = franquicia.obtenerSucursalPorId(idSucursal);
                    if (sucursal != null) {
                        sucursal.agregarProducto(new Producto(idProducto, nombreProducto, stock));
                    }
                    return franquicia;
                })
                .flatMap(franquiciaRepository::guardarFranquicia);
    }

    @Override
    public Mono<Franquicia> eliminarProducto(String idFranquicia, String idSucursal, String idProducto) {
        return franquiciaRepository.buscarFranquiciaById(idFranquicia)
                .map(franquicia -> {
                    Sucursal sucursal = franquicia.obtenerSucursalPorId(idSucursal);
                    if (sucursal != null) {
                        sucursal.eliminarProducto(idProducto);
                    }
                    return franquicia;
                })
                .flatMap(franquiciaRepository::guardarFranquicia);
    }

    @Override
    public Mono<Franquicia> actualizarStockProducto(String idFranquicia, String idSucursal, String idProducto, Integer nuevoStock) {
        return franquiciaRepository.buscarFranquiciaById(idFranquicia)
                .map(franquicia -> {
                    Sucursal sucursal = franquicia.obtenerSucursalPorId(idSucursal);
                    if (sucursal != null) {
                        Producto producto = sucursal.obtenerProductoPorId(idProducto);
                        if (producto != null) {
                            producto.setStock(nuevoStock);
                        }
                    }
                    return franquicia;
                })
                .flatMap(franquiciaRepository::guardarFranquicia);
    }

    @Override
    public Flux<String> obtenerProductosConMayorStockPorSucursal(String idFranquicia) {
        return franquiciaRepository.buscarFranquiciaById(idFranquicia)
                .flatMapMany(franquicia ->
                        Flux.fromIterable(franquicia.getSucursales())
                                .flatMap(sucursal -> Flux.fromIterable(sucursal.getProductos())
                                        .sort(Comparator.comparingInt(Producto::getStock).reversed())
                                        .take(1)
                                        .map(producto ->
                                                "Sucursal: " + sucursal.getNombre() +
                                                        ", Producto: " + producto.getNombreProducto() +
                                                        ", Stock: " + producto.getStock()
                                        )
                                )
                );
    }

    @Override
    public Mono<Franquicia> actualizarNombreFranquicia(String idFranquicia, String nuevoNombre) {
        return franquiciaRepository.buscarFranquiciaById(idFranquicia)
                .map(franquicia -> {
                    franquicia.setNombre(nuevoNombre);
                    return franquicia;
                })
                .flatMap(franquiciaRepository::guardarFranquicia);
    }

    @Override
    public Mono<Franquicia> actualizarNombreSucursal(String idFranquicia, String idSucursal, String nuevoNombre) {
        return franquiciaRepository.buscarFranquiciaById(idFranquicia)
                .map(franquicia -> {
                    Sucursal sucursal = franquicia.obtenerSucursalPorId(idSucursal);
                    if (sucursal != null) {
                        sucursal.setNombre(nuevoNombre);
                    }
                    return franquicia;
                })
                .flatMap(franquiciaRepository::guardarFranquicia);
    }

    @Override
    public Mono<Franquicia> actualizarNombreProducto(String idFranquicia, String idSucursal, String idProducto, String nuevoNombre) {
        return franquiciaRepository.buscarFranquiciaById(idFranquicia)
                .map(franquicia -> {
                    Sucursal sucursal = franquicia.obtenerSucursalPorId(idSucursal);
                    if (sucursal != null) {
                        Producto producto = sucursal.obtenerProductoPorId(idProducto);
                        if (producto != null) {
                            producto.setNombreProducto(nuevoNombre);
                        }
                    }
                    return franquicia;
                })
                .flatMap(franquiciaRepository::guardarFranquicia);
    }
}
