package com.example.day3_crud.service;

import com.example.day3_crud.model.StudentModel;
import com.example.day3_crud.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository repository;


    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentModel addStudent (StudentModel student){
        return repository.save(student);
    }
}
