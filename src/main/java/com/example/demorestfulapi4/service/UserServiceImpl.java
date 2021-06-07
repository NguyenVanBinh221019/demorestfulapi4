package com.example.demorestfulapi4.service;

import com.example.demorestfulapi4.util.converter.Mapper;
import com.example.demorestfulapi4.dto.UserDto;
import com.example.demorestfulapi4.entity.User;
import com.example.demorestfulapi4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    Mapper mapper;

    public UserDto getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        UserDto userDto = mapper.toUser(user);
        return userDto;
    }

    public UserDto saveUser(UserDto userDto) {
        User user = mapper.toUserDto(userDto);
        userRepository.save(user);
        UserDto userDto1 = mapper.toUser(Optional.of(user));
        return userDto1;
    }

    public UserDto currentUser(Long id, UserDto userDto) {
        Optional<User> user = userRepository.findById(id);
        user = Optional.ofNullable(mapper.toUserDto(userDto));
        userRepository.save(user.get());
        UserDto userDto1 = mapper.toUser(user);
        return userDto1;
    }

    public String deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        userRepository.delete(user.get());
        return "delete success";
    }



    public List<User> getUserByIdBetween(Long a, Long b) {
        List<User> users = userRepository.findAllByIdBetween(a, b);
        return users;
    }

    public List<UserDto> getAll() {
        List<UserDto> userDto = new ArrayList<>();
        List<User> users = userRepository.findAll();

        for(User user : users) {
            userDto.add(mapper.toUser(Optional.ofNullable(user)));
        }

        return userDto;
    }
}
