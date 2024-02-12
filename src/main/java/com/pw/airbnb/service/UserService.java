package com.pw.airbnb.service;

import com.pw.airbnb.entity.User;
import com.pw.airbnb.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public String createUser(User user){
        User savedUser = userRepository.save(user);
        if (savedUser != null) {
            return "success";
        } else return "failed";
    }

    public User checkValidUser(User user){
        //User returnedUser = userRepository.findUserByEmailAndPassword(user.getUserName(), user.getPassword());
        return this.userRepository.findUserByEmailAndPassword(user.getName(), user.getPassword());
    }
}
