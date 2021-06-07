package com.example.demorestfulapi4.util.converter;

import com.example.demorestfulapi4.dto.UserDto;
import com.example.demorestfulapi4.entity.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mapper {
    public User toUserDto(UserDto userDto) {
        User user = new User();
        user.setAddress(userDto.getAddress());
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setAge(userDto.getAge());

        return user;
    }

    public UserDto toUser(Optional<User> user) {
        UserDto userDto = new UserDto();
        userDto.setAddress(user.get().getAddress());
        userDto.setId(user.get().getId());
        userDto.setAge(user.get().getAge());
        userDto.setName(user.get().getName());

        return userDto;
    }
}
