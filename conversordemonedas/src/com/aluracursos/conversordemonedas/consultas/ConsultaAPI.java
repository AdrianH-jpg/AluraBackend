package com.aluracursos.conversordemonedas.consultas;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    String API_KEY = "1dc3bedb35791987c7b7a34f";
    String url_str = "https://v6.exchangerate-api.com/v6/" + API_KEY;
    public Conversor convertirMoneda(String target, String base, double amount){
        // Setting URL
        String conversor = url_str +"/pair/" + base + "/" + target + "/" + amount;
        URI direccion = URI.create(conversor);
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(direccion)
                .build();

        try {
            HttpResponse<String> response = cliente
                    .send(request,HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversor.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public ConversorCode codigosDeConvecion(){
        String codes = url_str + "codes";
        URI direccion = URI.create(codes);
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(direccion)
                .build();

        try {
            HttpResponse<String> response = cliente
                    .send(request,HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ConversorCode.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
