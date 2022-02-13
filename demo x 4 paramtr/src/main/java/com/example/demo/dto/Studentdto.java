package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Studentdto {
    private long id;
    private String name;
    public String institute;
    public Date birthdate;

}
