package edu.fiuba.algo3.modelo;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RickAndMortyApi {

    public HttpResponse<String> obtenerPersonaje(int idPersonaje) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(String.format("https://rickandmortyapi.com/api/character/%d",idPersonaje)))
                    .GET()
                    .build();
            HttpClient client = HttpClient.newBuilder().build();

            return client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
