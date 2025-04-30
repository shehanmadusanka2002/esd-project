package com.example.productmanagement.service;

import com.example.productmanagement.dto.UserRegistrationDto;
import com.example.productmanagement.model.User;
import com.example.productmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerNewUser(UserRegistrationDto registrationDto) {
        // Check if user already exists
        if (userRepository.existsByEmail(registrationDto.getEmail())) {
            throw new IllegalStateException("Email already taken");
        }

        // Create new user
        User user = new User();
        user.setName(registrationDto.getName());
        user.setEmail(registrationDto.getEmail());

        // Hash the password
        String encodedPassword = passwordEncoder.encode(registrationDto.getPassword());
        user.setPassword(encodedPassword);

        // Save user
        return userRepository.save(user);
    }
}
