package com.example.demorestfulapi4.controller;
import com.example.demorestfulapi4.dto.UserDto;
import com.example.demorestfulapi4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Service
@ResponseBody
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping
    public UserDto createUser(@RequestBody @Valid UserDto userDto) {
        return userService.saveUser(userDto);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userService.currentUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
//        return new ResponseEntity(userService.deleteUser(id), HttpStatus.OK);
//        return ResponseEntity.ok().build();
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @GetMapping
    public List<UserDto> findAll() {
        return userService.getAll();
    }
}