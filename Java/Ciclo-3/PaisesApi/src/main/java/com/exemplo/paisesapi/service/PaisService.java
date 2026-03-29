package com.exemplo.paisesapi.service;

import com.exemplo.paisesapi.model.Pais;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Service
public class PaisService {

    private static final String URL_BASE = "https://restcountries.com/v3.1/name/{nome}";

    private final RestClient restClient;

    public PaisService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.build();
    }

    public Pais buscarPorNome(String nome) {
        try {
            Pais[] paises = restClient.get()
                    .uri(URL_BASE, nome)
                    .retrieve()
                    .body(Pais[].class);

            if (paises == null || paises.length == 0) {
                throw new IllegalArgumentException("Nenhum país encontrado para o nome informado.");
            }

            return paises[0];
        } catch (RestClientException ex) {
            throw new IllegalArgumentException("Não foi possível consultar a API de países. Verifique o nome informado.", ex);
        }
    }
}
