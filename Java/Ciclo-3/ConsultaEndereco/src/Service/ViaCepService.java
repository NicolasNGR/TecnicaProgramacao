package Service;

import Model.Endereco;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ViaCepService {

    public Endereco buscarCep(String cep) {
        try {
            String cepLimpo = cep.replaceAll("[^0-9]", "");
            String urlStr = "https://viacep.com.br/ws/" + cepLimpo + "/json/";

            URL url = new URL(urlStr);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conexao.getInputStream(), "UTF-8"));

            StringBuilder resposta = new StringBuilder();
            String linha;

            while ((linha = br.readLine()) != null) {
                resposta.append(linha);
            }

            br.close();

            String json = resposta.toString();

            if (json.contains("\"erro\": true") || json.contains("\"erro\":true")) {
                return null;
            }

            String cepResp = extrairValor(json, "cep");
            String logradouro = extrairValor(json, "logradouro");
            String bairro = extrairValor(json, "bairro");
            String localidade = extrairValor(json, "localidade");
            String uf = extrairValor(json, "uf");

            return new Endereco(cepResp, logradouro, bairro, localidade, uf);

        } catch (Exception e) {
            System.out.println("Erro ao buscar CEP: " + e.getMessage());
            return null;
        }
    }

    private String extrairValor(String json, String campo) {
        String chave = "\"" + campo + "\":";
        int inicio = json.indexOf(chave);

        if (inicio == -1) {
            return "";
        }

        inicio = json.indexOf(":", inicio) + 1;

        while (inicio < json.length() && (json.charAt(inicio) == ' ' || json.charAt(inicio) == '"')) {
            inicio++;
        }

        int fim = inicio;

        while (fim < json.length() && json.charAt(fim) != '"' && json.charAt(fim) != ',') {
            fim++;
        }

        return json.substring(inicio, fim).trim();
    }
}