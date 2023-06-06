package com.example.services;


import com.example.domain.UserDto;
import com.example.domain.models.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);
}