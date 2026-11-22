package com.sharshdeep.controller;

import com.sharshdeep.dto.request.CreateStudentRequestDto;
import com.sharshdeep.dto.request.UpdateStudentRequestDto;
import com.sharshdeep.dto.response.CreateStudentResponseDto;
import com.sharshdeep.dto.response.UpdateStudentResponseDto;
import com.sharshdeep.entitiy.Student;
import com.sharshdeep.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    // 1. create student
    @PostMapping
    public ResponseEntity<CreateStudentResponseDto> createStudent(
            @Valid @RequestBody CreateStudentRequestDto student){

        CreateStudentResponseDto createdStudent = studentService.createStudent(student);
        return ResponseEntity
                .status(201)
                .body(createdStudent);
    }

    // 2. Read all students
    @GetMapping("/getAll")
    public ResponseEntity<List<CreateStudentResponseDto>> getStudents(){
    List<CreateStudentResponseDto> studentList=studentService.getAllStudents();
    if(studentList==null){
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.status(200).body(studentList);
    }

    // 3. Read Specific students
    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponseDto> getStudentById(@PathVariable(name = "id")  Long studentId){
    CreateStudentResponseDto studentResponse=studentService.getStudentById(studentId);
    if(studentResponse==null){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    return ResponseEntity.status(200).body(studentResponse);
    }

    // 3. Update student
    @PutMapping("/update/{id}")
    public ResponseEntity<UpdateStudentResponseDto> updateStudentById(
            @PathVariable(name = "id") Long studentId ,
            @RequestBody UpdateStudentRequestDto studentRequest){
       UpdateStudentResponseDto studentResponse= studentService.updateStudentById(studentId,studentRequest);

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

    @PatchMapping("/delete-soft")
    public ResponseEntity<Student> softDelete(@RequestParam Long id){
        Boolean isDeleted= studentService.softDeleteStudentById(id);
        if(!isDeleted){
            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(200).build();
    }
}
