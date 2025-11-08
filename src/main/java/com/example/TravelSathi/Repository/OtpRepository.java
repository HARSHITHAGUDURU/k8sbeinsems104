package com.example.TravelSathi.Repository;

import com.example.TravelSathi.Entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface OtpRepository extends JpaRepository<Otp, Long> {
    Optional<Otp> findByEmailAndOtpCode(String email, String otpCode);
}