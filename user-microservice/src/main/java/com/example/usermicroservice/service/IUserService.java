package com.example.usermicroservice.service;

import com.example.usermicroservice.dto.UserDto;
import com.example.usermicroservice.entity.User;

import java.util.List;

public interface IUserService {
    void saveUser(UserDto userDto);
    List<User> getAllUsers();
    User getUserById(Long id);
}
