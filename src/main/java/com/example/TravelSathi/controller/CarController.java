package com.example.TravelSathi.controller;

import com.example.TravelSathi.Entity.Car;
import com.example.TravelSathi.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
@CrossOrigin(origins = "http://localhost:5173")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carRepository.findAll());
    }
}