package com.project.mps.projmps.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Marcelo on 31/08/2019.
 */
@Entity
@Table(name = "Veiculo")
public class Veiculo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String ano_modelo;
    @NotNull
    private String ano_fabricacao;
    @NotNull
    private String cor;
    @NotNull
    private String placa;
    @NotNull
    private String quantidade_portas;
    @Embedded
    Marca marca;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAno_modelo() {
        return ano_modelo;
    }

    public void setAno_modelo(String ano_modelo) {
        this.ano_modelo = ano_modelo;
    }

    public String getAno_fabricacao() {
        return ano_fabricacao;
    }

    public void setAno_fabricacao(String ano_fabricacao) {
        this.ano_fabricacao = ano_fabricacao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getQuantidade_portas() {
        return quantidade_portas;
    }

    public void setQuantidade_portas(String quantidade_portas) {
        this.quantidade_portas = quantidade_portas;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
