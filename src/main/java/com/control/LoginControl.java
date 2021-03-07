package com.control;


import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public class LoginControl {

    @RequestMapping
    public String login() {

        return "index";
    }
}
