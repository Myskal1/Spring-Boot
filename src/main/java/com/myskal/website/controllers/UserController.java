package com.myskal.website.controllers;

import com.myskal.website.DTO.UserDTO;
import com.myskal.website.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@Api(tags = "Users")
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Get a user by ID", notes = "Retrieve details of a user based on its ID")
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @ApiOperation(value = "Get all users", notes = "Retrieve details of all users")
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @ApiOperation(value = "Create a new user", notes = "Create a new user with the provided details")
    @PostMapping("/users")
    public ResponseEntity<UserDTO> createUser(@Validated @RequestBody UserDTO newUser) {
        UserDTO savedUser = userService.saveUser(newUser);
        return ResponseEntity.created(URI.create("/api/users/" + savedUser.getId())).body(savedUser);
    }

    @ApiOperation(value = "Update a user", notes = "Update an existing user with the provided details")
    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @ApiOperation(value = "Delete a user", notes = "Delete a user based on its ID")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
