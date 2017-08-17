package com.example.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by japnica on 8/6/2017.
 */
@RestController
@RequestMapping("/api")
public class LoginController
{
    @PostMapping("/login")
    public String login(){
        return "Ur authorised";
    }
}
