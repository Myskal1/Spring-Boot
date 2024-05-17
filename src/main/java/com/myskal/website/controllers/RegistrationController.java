package com.myskal.website.controllers;

import com.myskal.website.controllers.RegistrationForm;
import com.myskal.website.entities.User;
import com.myskal.website.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Import BCryptPasswordEncoder
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegistrationForm form) {

        if (userRepository.findByUsername(form.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username already exists");
        }


        User user = new User();
        user.setUsername(form.getUsername());
        String hashedPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(hashedPassword);
        user.setEmail(form.getEmail());


        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully");
    }
}
