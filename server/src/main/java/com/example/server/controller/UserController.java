package com.example.server.controller;

import com.example.server.domain.User;
import com.example.server.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by japnica on 8/28/2017.
 */
@Controller
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<User> activateUser(@RequestParam String key){
        User user = userService.activateUser(key);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
