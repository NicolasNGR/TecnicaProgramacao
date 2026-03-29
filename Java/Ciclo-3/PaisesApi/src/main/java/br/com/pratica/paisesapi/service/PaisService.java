package br.com.pratica.paisesapi.service;

import br.com.pratica.paisesapi.dao.PaisDao;
import br.com.pratica.paisesapi.model.Pais;
import org.springframework.stereotype.Service;

@Service
public class PaisService {

    private final PaisDao paisDao;

    public PaisService(PaisDao paisDao) {
        this.paisDao = paisDao;
    }

    public Pais buscarPorNome(String nomePais) {
        return paisDao.buscarPorNome(nomePais.trim());
    }
}
