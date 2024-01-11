package edu.fiuba.algo3.helpers;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/*
*  Esta clase encapsula la interaccion con la API de Rick and Morty
*  - La documentacion de la API se puede encontrar en https://rickandmortyapi.com/documentation
*
*  - La documentacion sobre los objetos java.net.http se pueden encontrar en
*  https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/package-summary.html
*/
public class RickAndMortyApi {

    /*
    * Realiza una request por un solo personaje cuyo id coincide con idPersonaje
    * Documentacion: https://rickandmortyapi.com/documentation/#get-a-single-character
    * */
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

    /*
     * Realiza una request obteniendo multiples personajes
     * Documentacion: https://rickandmortyapi.com/documentation/#get-multiple-characters
     * */
    public HttpResponse<String> obtenerPersonajes(int[] idPersonajes) {
        try {
            String url = "https://rickandmortyapi.com/api/character/";
            for (int i = 0; i < idPersonajes.length; i++) {
                url = url.concat(String.format("%d,",idPersonajes[i]));
            }

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();
            HttpClient client = HttpClient.newBuilder().build();

            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
