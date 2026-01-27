package com.example.day3_crud.service;

import com.example.day3_crud.model.StudentModel;
import com.example.day3_crud.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;


    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // add student
    public StudentModel addStudent (StudentModel student){
        return repository.save(student);
    }

    //Display students

    public List<StudentModel> getStudents(){
        return repository.findAll();
    }


}
