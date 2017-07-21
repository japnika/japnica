package com.example.server.controller;

import com.example.server.domain.User;
import com.example.server.dto.UserDTO;
import com.example.server.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by japnica on 7/21/2017.
 */
@Controller
@RequestMapping("/api/register")
public class RegisterController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody UserDTO userDTO){
        User user = userService.saveUser(userDTO);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }
}
