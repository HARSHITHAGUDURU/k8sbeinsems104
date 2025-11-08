package com.example.TravelSathi.controller;

import com.example.TravelSathi.Entity.Stay;
import com.example.TravelSathi.Entity.Flight;
import com.example.TravelSathi.Entity.Car;
import com.example.TravelSathi.Repository.StayRepository;
import com.example.TravelSathi.Repository.FlightRepository;
import com.example.TravelSathi.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:5173")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private StayRepository stayRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private CarRepository carRepository;

    // Stay CRUD
    @PostMapping("/stay")
    public ResponseEntity<?> createStay(@RequestBody Stay stay) {
        stayRepository.save(stay);
        return ResponseEntity.ok("Stay created successfully");
    }

    @GetMapping("/stay")
    public List<Stay> getAllStays() {
        return stayRepository.findAll();
    }

    @PutMapping("/stay/{id}")
    public ResponseEntity<?> updateStay(@PathVariable Long id, @RequestBody Stay stay) {
        Optional<Stay> existing = stayRepository.findById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.badRequest().body("Stay not found");
        }
        stay.setId(id);
        stayRepository.save(stay);
        return ResponseEntity.ok("Stay updated successfully");
    }

    @DeleteMapping("/stay/{id}")
    public ResponseEntity<?> deleteStay(@PathVariable Long id) {
        stayRepository.deleteById(id);
        return ResponseEntity.ok("Stay deleted successfully");
    }

    // Flight CRUD
    @PostMapping("/flight")
    public ResponseEntity<?> createFlight(@RequestBody Flight flight) {
        flightRepository.save(flight);
        return ResponseEntity.ok("Flight created successfully");
    }

    @GetMapping("/flight")
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @PutMapping("/flight/{id}")
    public ResponseEntity<?> updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
        Optional<Flight> existing = flightRepository.findById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.badRequest().body("Flight not found");
        }
        flight.setId(id);
        flightRepository.save(flight);
        return ResponseEntity.ok("Flight updated successfully");
    }

    @DeleteMapping("/flight/{id}")
    public ResponseEntity<?> deleteFlight(@PathVariable Long id) {
        flightRepository.deleteById(id);
        return ResponseEntity.ok("Flight deleted successfully");
    }

    // Car CRUD
    @PostMapping("/car")
    public ResponseEntity<?> createCar(@RequestBody Car car) {
        carRepository.save(car);
        return ResponseEntity.ok("Car created successfully");
    }

    @GetMapping("/car")
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @PutMapping("/car/{id}")
    public ResponseEntity<?> updateCar(@PathVariable Long id, @RequestBody Car car) {
        Optional<Car> existing = carRepository.findById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.badRequest().body("Car not found");
        }
        car.setId(id);
        carRepository.save(car);
        return ResponseEntity.ok("Car updated successfully");
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Long id) {
        carRepository.deleteById(id);
        return ResponseEntity.ok("Car deleted successfully");
    }
}