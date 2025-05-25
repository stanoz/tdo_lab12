package org.demo.tdo_lab12_demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
public class DataControllerIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void testGetApiData() {
        String url = "http://localhost:" + port + "/api/status";
        ResponseEntity<String> response = testRestTemplate.getForEntity(url, String.class);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Java 21, up and running", response.getBody());
    }

    @Test
    void testGetJsonData() {
        String url = "http://localhost:" + port + "/api/data";
        ResponseEntity<String> response = testRestTemplate.getForEntity(url, String.class);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Some data", response.getBody());
    }

}
