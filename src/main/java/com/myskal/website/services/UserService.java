package com.myskal.website.services;

import com.myskal.website.DTO.UserDTO;
import com.myskal.website.DTO.UserRequest;
import com.myskal.website.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDTO getUserById(Long id);

    UserDTO saveUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    UserDTO createUser(UserDTO userDTO) throws UsernameAlreadyExistsException;

    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);

    Optional<User> findByEmail(String email);

    void save(User user);

    void registerUser(UserRequest userRequest);
}
