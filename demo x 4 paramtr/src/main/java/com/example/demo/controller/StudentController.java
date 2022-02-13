package com.example.demo.controller;

import com.example.demo.dto.Studentdto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.Studentservice;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final Studentservice  service;
    @GetMapping("/{id}")
    public Studentdto getStudentbyid(@PathVariable Long id)
    {
       return service.getStudentbyid(id);
    }
    @PostMapping
    public  Studentdto createStudent(@RequestBody Studentdto dto)
    {
        return service.createStudent(dto);
    }
    @PutMapping
    public  Studentdto updateStudent(@RequestBody Studentdto dto)
    {
        return service.updateStudent(dto);
    }
    @DeleteMapping("/{id}")
    public  void deleteStudent(@PathVariable Long id)
    {
        service.deleteStudent(id);
    }
}
