package com.project.mps.projmps.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * Created by Marcelo on 31/08/2019.
 */
@Embeddable
public class Marca {

    @NotNull
    String nome_marca;
    @NotNull
    String modelo;

    public String getNome_marca() {
        return nome_marca;
    }

    public void setNome_marca(String nome_marca) {
        this.nome_marca = nome_marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
