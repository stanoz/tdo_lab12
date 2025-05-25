package org.demo.tdo_lab12_demo;

import org.demo.tdo_lab12_demo.services.DataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataServiceTest {
    @Test
    void testGetApiData() {
        DataService dataService = new DataService();
        String result = dataService.getApiData();
        assertEquals("Java 21, up and running", result);
    }

    @Test
    void testGetJsonData() {
        DataService dataService = new DataService();
        String result = dataService.getJsonData();
        assertEquals("Some data", result);
    }
}
