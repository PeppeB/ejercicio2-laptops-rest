package com.example.ejercicio2laptopsrest.controllers;

import com.example.ejercicio2laptopsrest.entities.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void findAll() {

        ResponseEntity<Laptop[]> response =
                testRestTemplate.getForEntity("/api/laptops", Laptop[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());

        List<Laptop> laptops = Arrays.asList(response.getBody());
        System.out.println(laptops.size());
    }

    @Test
    void findOneById() {
        ResponseEntity<Laptop> response =
                testRestTemplate.getForEntity("/api/laptops/1", Laptop.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                	"brand": "Lenovo",
                	"model": "Legion 7 Gaming",
                	"color": "Storm Grey",
                	"display": "16.0 inches QHD IPS Display 160Hz",
                	"graphicCard": "NVIDIA GeForce RTX 3080 16GB GDDR6",
                	"processor": "AMD Ryzen™ 9 5900HX",
                	"storage": "1TB SSD",
                	"ram": "32GB DDR4",
                	"microphoneType": "Internal Microphone",
                	"webcamType": "Internal Webcam",
                	"speakersType": null,
                	"hasOpticalDrive": false,
                	"hasFingerprintScanner": false,
                	"hasBluetooth": true,
                	"hasSdCardReader": null,
                	"nrUsbPorts": 3,
                	"batteryType": null,
                	"operatingSystem": "Windows 11 Home 64-bit"
                }
                """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Laptop> response =
                testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);

        Laptop result = response.getBody();

        assertEquals(1L, result.getId());
        assertEquals("Lenovo", result.getBrand());
        assertEquals("Legion 7 Gaming", result.getModel());
        assertEquals("Storm Grey", result.getColor());
        assertEquals("16.0 inches QHD IPS Display 160Hz", result.getDisplay());
        assertEquals("NVIDIA GeForce RTX 3080 16GB GDDR6", result.getGraphicCard());
        assertEquals("AMD Ryzen™ 9 5900HX", result.getProcessor());
        assertEquals("1TB SSD", result.getStorage());
        assertEquals("32GB DDR4", result.getRam());
        assertEquals("Internal Microphone", result.getMicrophoneType());
        assertEquals("Internal Webcam", result.getWebcamType());
        assertNull(result.getSpeakersType());
        assertFalse(result.getHasOpticalDrive());
        assertFalse(result.getHasFingerprintScanner());
        assertTrue(result.getHasBluetooth());
        assertNull(result.getHasSdCardReader());
        assertEquals(3, result.getNrUsbPorts());
        assertNull(result.getBatteryType());
        assertEquals("Windows 11 Home 64-bit", result.getOperatingSystem());
    }
}