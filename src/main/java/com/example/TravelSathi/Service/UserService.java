package com.example.TravelSathi.Service;

import com.example.TravelSathi.Entity.User;

public interface UserService {
    String registerUser(User user);
    String loginUser(String email, String password);
}