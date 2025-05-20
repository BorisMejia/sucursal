package com.franquicia.sucursal.infra.driven.mongo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "franquicias")
@AllArgsConstructor
@NoArgsConstructor
public class FranquiciaDocument {

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<SucursalDocument> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<SucursalDocument> sucursales) {
        this.sucursales = sucursales;
    }

    private String nombre;

    private List<SucursalDocument> sucursales;
}
