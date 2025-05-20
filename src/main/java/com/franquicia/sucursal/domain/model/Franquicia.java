package com.franquicia.sucursal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Franquicia {

    private final String id;
    private String nombre;
    private final List<Sucursal> sucursales;

    public Franquicia(String nombre) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.sucursales = new ArrayList<>();
    }

    public Franquicia(String id, String nombre, List<Sucursal> sucursales) {
        this.id = id;
        this.nombre = nombre;
        this.sucursales = sucursales;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public void agregarSucursal(Sucursal sucursal) {
        this.sucursales.add(sucursal);
    }

    public void eliminarSucursal(String idSucursal) {
        this.sucursales.removeIf(s -> s.getId().equals(idSucursal));
    }

    public Sucursal obtenerSucursalPorId(String idSucursal) {
        return this.sucursales.stream()
                .filter(s -> s.getId().equals(idSucursal))
                .findFirst()
                .orElse(null);
    }
}
