package client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

import model.Empresa;

public class BrasilApiClient {

    private static final String URL = "https://brasilapi.com.br/api/cnpj/v1/";

    public Empresa buscar(String cnpj) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + cnpj))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {

            Gson gson = new Gson();
            return gson.fromJson(response.body(), Empresa.class);

        } else {

            throw new RuntimeException("Erro ao consultar API");
        }
    }
}