package edu.fiuba.algo3.architecture;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RickAndMortyApiTest {
    @Test
    public void ResponseStatusIsHttpOk() throws java.net.URISyntaxException, IOException, InterruptedException {
        // Arrange
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://rickandmortyapi.com/api/character/1,183"))
                .GET()
                .build();
        HttpClient client = HttpClient.newBuilder().build();

        // Act
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Assert
        int HTTP_OK = 200;
        assertEquals(response.statusCode(),HTTP_OK);
    }
}
