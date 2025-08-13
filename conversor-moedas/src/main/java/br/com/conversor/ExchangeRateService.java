package br.com.conversor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ExchangeRateService {
    private static final String API_KEY = "9723dfedf30a7ffaabc09536";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public double obterTaxa(String moedaOrigem, String moedaDestino) {
        String url = BASE_URL + API_KEY + "/latest/" + moedaOrigem;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();

            JsonObject json = JsonParser.parseString(body).getAsJsonObject();

            if (!json.get("result").getAsString().equals("success")) {
                return -1;
            }

            JsonObject conversionRates = json.getAsJsonObject("conversion_rates");

            return conversionRates.get(moedaDestino).getAsDouble();
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao acessar a API: " + e.getMessage());
            return -1;
        }
    }
}
