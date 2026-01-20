package com.example.day3_crud.repository;

import com.example.day3_crud.model.StudentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository <StudentModel,String> {

}
