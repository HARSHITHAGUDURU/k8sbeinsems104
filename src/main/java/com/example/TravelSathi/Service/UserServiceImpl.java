package com.example.TravelSathi.Service;

import com.example.TravelSathi.Entity.User;
import com.example.TravelSathi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String registerUser(User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return "User already registered!";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        user.setRole(user.getRole() != null ? user.getRole() : "USER"); // Default to USER
        userRepository.save(user);
        return "Registration success!";
    }

    @Override
    public String loginUser(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            return "User not found";
        }
        User user = userOptional.get();
        if (passwordEncoder.matches(password, user.getPassword())) {
            return "Login successful!";
        } else {
            return "Invalid credentials";
        }
    }
}