package com.sharshdeep.controller;

import com.sharshdeep.entitiy.Student;
import com.sharshdeep.service.StudentService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

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
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getStudents(){
    List<Student> studentList=studentService.getAllStudents();
    if(studentList==null){
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.status(200).body(studentList);
    }

    // 3. Read Specific students
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(name = "id")  Long studentId){
    Student studentResponse=studentService.getStudentById(studentId);
    if(studentResponse==null){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    return ResponseEntity.status(200).body(studentResponse);
    }

    // 3. Update student
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudentById( @PathVariable(name = "id") Long studentId ,
                                                      @RequestBody Student studentRequest){
       Student studentResponse= studentService.updateStudentById(studentId,studentRequest);

       if(studentResponse==null){
           return ResponseEntity.status(404).build();
       }

       return ResponseEntity.status(200).body(studentResponse);

    }

    // 4. Delete student
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudentsById( @PathVariable Long id){
        Boolean isDeleted= studentService.deleteStudentById(id);

        if(!isDeleted){
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.ok("Response Deleted");
    }
}
