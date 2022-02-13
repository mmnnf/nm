package com.example.demo.service;

import com.example.demo.dto.Studentdto;

public interface Studentservice {
    Studentdto getStudentbyid(Long id);
    Studentdto createStudent(Studentdto dto);
    void deleteStudent(Long id);
    Studentdto updateStudent(Studentdto  dto);
}
