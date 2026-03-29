package br.com.pratica.paisesapi.model;

import jakarta.validation.constraints.NotBlank;

public class PaisFormulario {

    @NotBlank(message = "Informe o nome do país em inglês.")
    private String nomePais;

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }
}
