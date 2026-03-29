package br.com.pratica.paisesapi.dao;

import br.com.pratica.paisesapi.model.Pais;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;
import org.springframework.web.server.ResponseStatusException;

@Repository
public class PaisApiDao implements PaisDao {

    private final RestClient restClient;
    private final ObjectMapper objectMapper;

    public PaisApiDao(ObjectMapper objectMapper) {
        this.restClient = RestClient.builder()
                .baseUrl("https://restcountries.com")
                .build();
        this.objectMapper = objectMapper;
    }

    @Override
    public Pais buscarPorNome(String nomePais) {
        String json = restClient.get()
                .uri("/v3.1/name/{nome}", nomePais)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "País não encontrado.");
                })
                .onStatus(HttpStatusCode::is5xxServerError, (request, response) -> {
                    throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Erro ao consultar a API de países.");
                })
                .body(String.class);

        try {
            JsonNode primeiroPais = objectMapper.readTree(json).get(0);

            Pais pais = new Pais();
            pais.setNomeComum(primeiroPais.path("name").path("common").asText());
            pais.setNomeOficial(primeiroPais.path("name").path("official").asText());
            pais.setCapital(obterCapital(primeiroPais.path("capital")));
            pais.setRegiao(primeiroPais.path("region").asText());
            pais.setSubRegiao(primeiroPais.path("subregion").asText());
            pais.setPopulacao(primeiroPais.path("population").asLong());
            pais.setArea(primeiroPais.path("area").asDouble());
            pais.setUrlBandeira(primeiroPais.path("flags").path("png").asText());
            return pais;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Erro ao processar os dados do país.");
        }
    }

    private String obterCapital(JsonNode capitalNode) {
        if (capitalNode.isArray() && !capitalNode.isEmpty()) {
            return capitalNode.get(0).asText();
        }
        return "Não informada";
    }
}
