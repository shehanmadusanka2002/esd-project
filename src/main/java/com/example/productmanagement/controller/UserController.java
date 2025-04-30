package com.example.productmanagement.controller;

import com.example.productmanagement.dto.UserRegistrationDto;
import com.example.productmanagement.model.User;
import com.example.productmanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegistrationDto registrationDto) {
        try {
            User registeredUser = userService.registerNewUser(registrationDto);

            Map<String, Object> response = new HashMap<>();
            response.put("id", registeredUser.getId());
            response.put("name", registeredUser.getName());
            response.put("email", registeredUser.getEmail());
            response.put("createdAt", registeredUser.getCreatedAt());

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }
}