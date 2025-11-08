package com.example.TravelSathi.controller;

import com.example.TravelSathi.Entity.Flight;
import com.example.TravelSathi.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flight")
@CrossOrigin(origins = "http://localhost:5173")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        return ResponseEntity.ok(flightRepository.findAll());
    }
}