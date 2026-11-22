package com.saini.singh.harsheep.dtoValidationsDemo.controller;


import com.saini.singh.harsheep.dtoValidationsDemo.entity.Student;
import com.saini.singh.harsheep.dtoValidationsDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {


    StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    // create
    public ResponseEntity<Student> create(@RequestBody Student student){
       Student studentResponse= studentService.createStudent(student);

       return ResponseEntity.ok(studentResponse);
    }
    // read

    //update

    //delete
}
