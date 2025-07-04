package com.franquicia.sucursal.infra.driven.mongo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "franquicias")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FranquiciaDocument {

    @Id
    private String id;

    private String nombre;

    private List<SucursalDocument> sucursales;
}
