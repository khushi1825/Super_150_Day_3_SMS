package com.example.day3_crud.controller;


import com.example.day3_crud.model.StudentModel;
import com.example.day3_crud.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/add-student")
    public StudentModel addStudent(@RequestBody StudentModel student){
        return service.addStudent(student);
    }
}
