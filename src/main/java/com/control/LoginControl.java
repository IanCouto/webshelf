package com.control;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public class LoginControl {
    @GetMapping
    public String login() {
        return "index";
    }
}
