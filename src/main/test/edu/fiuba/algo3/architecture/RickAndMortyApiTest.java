package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.RickAndMortyApi;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RickAndMortyApiTest {
    @Test
    public void ResponseStatusIsHttpOk(){
        // Arrange
        RickAndMortyApi api = new RickAndMortyApi();

        // Act
        HttpResponse<String> response = api.obtenerPersonaje(1);

        // Assert
        int HTTP_OK = 200;
        assertEquals(response.statusCode(),HTTP_OK);
    }
}
