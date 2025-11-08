package com.example.TravelSathi.controller;

import com.example.TravelSathi.Entity.Booking;
import com.example.TravelSathi.Entity.User;
import com.example.TravelSathi.Repository.BookingRepository;
import com.example.TravelSathi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/booking")
@CrossOrigin(origins = "http://localhost:5173")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        booking.setUser(user);
        booking.setBookingDate(LocalDate.now());
        bookingRepository.save(booking);
        return ResponseEntity.ok("Booking created successfully");
    }

    @GetMapping
    public ResponseEntity<?> getUserBookings() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        return ResponseEntity.ok(bookingRepository.findAll().stream()
                .filter(b -> b.getUser().getId().equals(user.getId()))
                .toList());
    }
}