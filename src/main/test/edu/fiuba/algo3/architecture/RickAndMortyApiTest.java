package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.RickAndMortyApi;

import org.junit.jupiter.api.Test;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.http.HttpResponse;

public class RickAndMortyApiTest {
    @Test
    public void ResponseStatusIsHttpOk(){
        // Arrange
        RickAndMortyApi api = new RickAndMortyApi();

        // Act
        HttpResponse<String> response = api.obtenerPersonaje(1);

        // Assert
        assertEquals(response.statusCode(),HTTP_OK);
    }

    @Test
    public void PersonajeTieneIdCorrecto(){
        // Arrange
        RickAndMortyApi api = new RickAndMortyApi();

        // Act
        HttpResponse<String> response = api.obtenerPersonaje(1);

        // Assert
        assertTrue(response.body().contains("\"id\":1"));
    }

    @Test
    public void ListaDeDosPersonajes(){
        // Arrange
        RickAndMortyApi api = new RickAndMortyApi();
        int[] idPersonajes = new int[]{ 1,2};

        // Act
        HttpResponse<String> response = api.obtenerPersonajes(idPersonajes);

        // Assert
        assertEquals(response.statusCode(),HTTP_OK);
    }

    @Test
    public void PersonajesTienenIdCorrectos(){
        // Arrange
        RickAndMortyApi api = new RickAndMortyApi();
        int[] idPersonajes = new int[]{ 1,2};

        // Act
        HttpResponse<String> response = api.obtenerPersonajes(idPersonajes);

        // Assert
        assertTrue(response.body().contains("\"id\":1"));
        assertTrue(response.body().contains("\"id\":2"));
    }
}
