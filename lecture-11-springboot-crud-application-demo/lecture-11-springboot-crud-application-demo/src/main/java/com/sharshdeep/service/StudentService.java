package com.sharshdeep.service;

import com.sharshdeep.entitiy.Student;
import com.sharshdeep.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public Student createStudent(Student student) {
        Student studentResponse= studentRepository.saveStudent(student);
    return studentResponse;
    }
}
