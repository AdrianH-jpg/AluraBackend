package com.aluracursos.principal;

import com.aluracursos.screeanmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.aluracursos.screeanmatch.modelos.Titulo;
import com.aluracursos.screeanmatch.modelos.TituloOMdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        var APIKEY = "bd0a8266";
        List<Titulo> titulos = new ArrayList<>();
        Scanner lectura = new Scanner(System.in);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        while (true){
            System.out.println("Escriba el nombre de una pelicula: ");
            var busqueda = lectura.nextLine();


            if(busqueda.equalsIgnoreCase("salir"))
            {
                break;
            }
            String direccion = "https://www.omdbapi.com/?t=" + busqueda + "&apikey=" + APIKEY;

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request =  HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);


                TituloOMdb miTituloOmdb = gson.fromJson(json, TituloOMdb.class);
                System.out.println(miTituloOmdb);
                Titulo miTitulo = new Titulo(miTituloOmdb);
                System.out.println("Titulo ya convertido: " + miTitulo);
                titulos.add(miTitulo);
            }catch (NumberFormatException e){
                System.out.println("Ocurrió un error: ");
                System.out.println(e.getMessage());
            }catch(IllegalArgumentException e){
                System.out.println("Error en la URI, verifique la dirección.");
            }catch (ErrorEnConversionDeDuracionException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titulos);
        FileWriter escritura = new FileWriter("titulos.json");
        escritura.write(gson.toJson(titulos));
        escritura.close();
        System.out.println("Finalizó la ejecución del programa!");
    }
}
