package com.saini.singh.harsheep.dtoValidationsDemo.service;

import com.saini.singh.harsheep.dtoValidationsDemo.entity.Student;
import com.saini.singh.harsheep.dtoValidationsDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public Student createStudent(Student studentReq){
        Student savedStudent=studentRepository.save(studentReq);
        return  savedStudent;
    }
}
