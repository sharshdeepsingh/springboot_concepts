package com.sharshdeep.controller;

import com.sharshdeep.entitiy.Student;
import com.sharshdeep.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    // 1. create student
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity
                .status(201)
                .body(createdStudent);
    }

    // 2. Read all students
    @GetMapping
    public void getStudents(){

    }

    // 3. Read Specific students
    @GetMapping("{id}")
    public void getStudentById(){

    }

    // 3. Update student
    @PutMapping("{id}")
    public void updateStudentById(){

    }

    // 4. Delete student
    @DeleteMapping("{id}")
    public void deleteStudentsById(){

    }
}
