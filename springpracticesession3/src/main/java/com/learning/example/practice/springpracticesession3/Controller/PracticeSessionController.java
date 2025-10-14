package com.learning.example.practice.springpracticesession3.Controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sesion-1")
public class PracticeSessionController {

    @GetMapping(path = "/checking")
    public String requestMapping()
    {
        return "parctice session prcatice";
    }
}
