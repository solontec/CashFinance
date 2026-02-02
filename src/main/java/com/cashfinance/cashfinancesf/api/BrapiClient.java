package com.cashfinance.cashfinancesf.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BrapiClient {

    private static final String url = "https://brapi.dev/api/quote/";

    private final HttpClient client;

    public BrapiClient(){
        this.client = HttpClient.newHttpClient();

    }
    public String searchAction(String ticker) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + ticker)).GET().build();


        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Error for search Action" + response.statusCode());
            }

            return response.body();
        } catch (Exception e) {
            throw new RuntimeException("Comunicate error", e);
        }
    }

}
