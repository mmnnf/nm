package com.example.demo.service;

import com.example.demo.dto.Studentdto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface Studentservice {
    Studentdto getStudentbyid(Long id);
    Studentdto createStudent(Studentdto dto);
    void deleteStudent(Long id);
    Studentdto updateStudent(Studentdto  dto);
     List<Studentdto> gettt( ) ;
}
