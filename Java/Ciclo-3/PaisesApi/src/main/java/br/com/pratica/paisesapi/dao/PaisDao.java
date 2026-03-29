package br.com.pratica.paisesapi.dao;

import br.com.pratica.paisesapi.model.Pais;

public interface PaisDao {
    Pais buscarPorNome(String nomePais);
}
