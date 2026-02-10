package com.example.day3_crud.controller;


import com.example.day3_crud.dto.StudentRequestDto;
import com.example.day3_crud.dto.StudentResponseDto;
import com.example.day3_crud.model.StudentModel;
import com.example.day3_crud.service.StudentService;
import com.example.day3_crud.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@CrossOrigin(origins="*")
@RestController


public class StudentController {
    private final StudentService service;
    private final JwtUtil jwtUtil;

    public StudentController(StudentService service,JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil=jwtUtil;
    }

    private void checkToken(String authHeader){
        if (authHeader ==null || authHeader.startsWith("Bearer")){
            throw new RuntimeException("Invalid token");
        }

        String token=authHeader.substring(7);
        jwtUtil.validateTokenAndGetEmail(token);
    }

    @PostMapping("/add-students")
    public StudentResponseDto addStudent( @RequestHeader("Authorized") String authHeader ,@Valid @RequestBody StudentRequestDto student) {
        return service.addStudent(student);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> getStudents(@RequestHeader(value="Authorizion",required = false) String authHeader) {
        checkToken(authHeader);
        return service.getStudents();
    }

    @PutMapping("/update/{id}")
    public StudentResponseDto updateStudent(@PathVariable String id, @RequestBody StudentRequestDto student) {
        return service.updateStudent(id, student);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable String id) {
        service.deleteStudent(id);
    }



}

