package com.example.TravelSathi.Repository;

import com.example.TravelSathi.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}