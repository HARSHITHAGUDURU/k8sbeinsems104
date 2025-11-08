package com.example.TravelSathi.controller;

import com.example.TravelSathi.Entity.Stay;
import com.example.TravelSathi.Repository.StayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stay")
@CrossOrigin(origins = "http://localhost:5173")
public class StayController {

    @Autowired
    private StayRepository stayRepository;

    @GetMapping
    public ResponseEntity<List<Stay>> getAllStays() {
        return ResponseEntity.ok(stayRepository.findAll());
    }
}