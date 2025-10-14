package com.learning.example.practice.springpracticesession3.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/login")
public class LoginController {

    @GetMapping(path = "/loginUser")
    public String loginuser()
    {
        return "login succeeddd";
    }
}
