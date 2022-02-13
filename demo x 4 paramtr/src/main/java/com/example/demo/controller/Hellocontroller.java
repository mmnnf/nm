package com.example.demo.controller;

import com.example.demo.dto.Studentdto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Hellocontroller {
    @GetMapping
    public Studentdto sayhello(@RequestBody Studentdto dto)
    {
        return dto;
    }

    @GetMapping("/2")
    public String sayhello2(@RequestBody Studentdto dto)
    {
        return "hello"+dto.getName();
    }
}
