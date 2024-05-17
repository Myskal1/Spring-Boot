package com.myskal.website.controllers;

import com.myskal.website.DTO.UserDTO;
import com.myskal.website.DTO.UserDetailsImpl;
import com.myskal.website.services.UserService;
import com.myskal.website.services.UsernameAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("register")
    public ResponseEntity<?> registerNewUser(@Validated @RequestBody UserDTO userDTO) throws UsernameAlreadyExistsException {
        UserDTO savedUser = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping
    public ResponseEntity<?> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetailsImpl principal) {
            principal.getUser().setPassword(null);
            return ResponseEntity.ok(principal.getUser());
        }
        return ResponseEntity.notFound().build();
    }
}
