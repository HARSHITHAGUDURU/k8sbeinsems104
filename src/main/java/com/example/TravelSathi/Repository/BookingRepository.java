package com.example.TravelSathi.Repository;

import com.example.TravelSathi.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}