package com.franquicia.sucursal.infra.driven.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "franquicias")
public class FranquiciaDocument {
    private String idFranquicia;
    private String nombreFranquicia;
    private List<SucursalDocument> sucursales;
}
