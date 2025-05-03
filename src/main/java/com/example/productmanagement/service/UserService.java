package com.example.userregistration.service;

import com.example.userregistration.dto.UserDTO;
import com.example.userregistration.entity.User;

import java.util.List;

public interface UserService {
    User createUser(UserDTO userDTO);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
}
