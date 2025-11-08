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

        // ✅ Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // ✅ Enable user account by default
        user.setEnabled(true);

        // ✅ Default role to USER if not provided
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("USER");
        }

        userRepository.save(user);
        return "Registration success!";
    }

    /**
     * ⚠️ This method is not used because authentication is handled
     * via AuthenticationManager in UserController. You can safely remove it.
     * 
     * Keeping it here for completeness if you ever want manual login check.
     */
    @Override
    public String loginUser(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            return "User not found";
        }

        User user = userOptional.get();

        // ✅ Compare raw password with encoded password
        if (passwordEncoder.matches(password, user.getPassword())) {
            return "Login successful!";
        } else {
            return "Invalid credentials";
        }
    }
}
