package com.example.demo.repostery;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Studentrepostery extends JpaRepository<Student,Long> {

}
