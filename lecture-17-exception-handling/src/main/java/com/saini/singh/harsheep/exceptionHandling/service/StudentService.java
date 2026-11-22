package com.saini.singh.harsheep.exceptionHandling.service;

import com.saini.singh.harsheep.exceptionHandling.entity.Student;
import com.saini.singh.harsheep.exceptionHandling.repository.StudentRepository;
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
