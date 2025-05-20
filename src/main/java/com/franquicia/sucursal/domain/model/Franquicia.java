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

    public Franquicia(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.sucursales = new ArrayList<>();
    }

    public Franquicia(String id, String nombre, List<Sucursal> sucursales) {
        this.id = id;
        this.nombre = nombre;
        this.sucursales = sucursales;
    }

    public void agregarSucursal(Sucursal nueva) {
        if (sucursales.stream().anyMatch(s -> s.getId().equals(nueva.getId()))) {
            throw new IllegalArgumentException("Ya existe una sucursal con ID: " + nueva.getId());
        }
        this.sucursales.add(nueva);
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

    public void eliminarSucursal(String idSucursal) {
        this.sucursales.removeIf(s -> s.getId().equals(idSucursal));
    }

    public Sucursal obtenerSucursalPorId(String idSucursal) {
        return this.sucursales.stream()
                .filter(s -> s.getId().equals(idSucursal))
                .findFirst()
                .orElse(null);
    }
    public Franquicia() {
        this.id = null;
        this.nombre = null;
        this.sucursales = new ArrayList<>();
    }
}
