package com.portfolio.user_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController // (1) Marks this class as a REST Controller, ready to handle web requests.
@RequestMapping("/api/users") // (2) Sets the base URL for all methods in this class.
public class UserController {

    private final UserRepository userRepository; // (3) A variable to hold our database tool.

    @Autowired // (4) Tells Spring to automatically find the UserRepository bean and inject it here.
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // --- Endpoint 1: Create a new user ---
    @PostMapping("/register") // (5) Maps HTTP POST requests to /api/users/register to this method.
    public ResponseEntity<User> registerUser(@RequestBody User newUser) { // (6)
        User savedUser = userRepository.save(newUser); // (7)
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED); // (8)
    }

    // --- Endpoint 2: Get a user by their ID ---
    @GetMapping("/{id}") // (9) Maps HTTP GET requests to /api/users/{some_id} to this method.
    public ResponseEntity<User> getUserById(@PathVariable Long id) { // (10)
        Optional<User> userData = userRepository.findById(id); // (11)

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK); // (12)
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // (13)
        }
    }
}
