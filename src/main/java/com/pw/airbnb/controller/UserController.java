package com.pw.airbnb.controller;

import com.pw.airbnb.entity.User;
import com.pw.airbnb.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airbnb/api/v1/users")
@CrossOrigin("http://localhost:4200")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){this.userService = userService;}

    @PostMapping

    //url: http://localhost:8082/airbnb/api/v1/users
    public ResponseEntity<String> createUser(@Valid @RequestBody User user){
        String result = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @GetMapping
    //url: http://localhost:8082/airbnb/api/v1/users
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }
    //url: http://localhost:8082/airbnb/api/v1/users/login
    @PostMapping("/login")
    public ResponseEntity<User> checkValidUser(@RequestBody User user){
        return ResponseEntity.ok(userService.checkValidUser(user));
    }

}
