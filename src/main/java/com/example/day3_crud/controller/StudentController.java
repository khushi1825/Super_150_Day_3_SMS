package com.example.day3_crud.controller;


import com.example.day3_crud.dto.StudentRequestDto;
import com.example.day3_crud.dto.StudentResponseDto;
import com.example.day3_crud.model.StudentModel;
import com.example.day3_crud.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/add-student")
    public StudentResponseDto addStudent(@Valid @RequestBody StudentRequestDto student) {
        return service.addStudent(student);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> getStudents() {
        return service.getStudents();
    }

    @PutMapping("/update/{id}")
    public StudentModel updateStudent(@PathVariable String id, @RequestBody StudentModel student) {
        return service.updateStudent(id, student);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable String id) {
        service.deleteStudent(id);
    }
}

