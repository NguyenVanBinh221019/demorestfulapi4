package com.example.demorestfulapi4.service;

import com.example.demorestfulapi4.dto.UserDto;
import com.example.demorestfulapi4.entity.User;
import com.example.demorestfulapi4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {
    UserDto getUser(Long id);
    UserDto saveUser(UserDto userDto);
    UserDto currentUser(Long id, UserDto userDto);
    String deleteUser(Long id);
    List<User> getUserByIdBetween(Long a, Long b);
    List<UserDto> getAll();
}
