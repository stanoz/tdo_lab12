package org.demo.tdo_lab12_demo.controllers;

import lombok.RequiredArgsConstructor;
import org.demo.tdo_lab12_demo.services.DataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DataController {
    private final DataService dataService;

    @GetMapping("/status")
    public ResponseEntity<String> getApiData() {
        return ResponseEntity.ok(dataService.getApiData());
    }

    @GetMapping("/data")
    public ResponseEntity<String> getJsonData() {
        return ResponseEntity.ok(dataService.getJsonData());
    }
}
