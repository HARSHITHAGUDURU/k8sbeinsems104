package com.example.TravelSathi.Repository;

import com.example.TravelSathi.Entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}