package com.sharshdeep.service;

import com.sharshdeep.entitiy.Student;
import com.sharshdeep.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public  List<Student> getAllStudents() {
        List<Student> studentList= studentRepository.findAll();
        return studentList;
    }

    public Student createStudent(Student studentReq) {
        return studentRepository.save(studentReq);
    }

    public Student getStudentById( Long studentId) {
       Optional<Student> studentResponse=studentRepository.findById(studentId);

        return studentResponse.orElse(null);
    }

    public Student updateStudentById(Long studentId, Student studentRequest) {

        Optional<Student> existingStudent=studentRepository.findById(studentId);
        if(existingStudent.isEmpty()){
            return null;
        }
        Student studentToSave=existingStudent.get();
        studentToSave.setName(studentRequest.getName());
        studentToSave.setAge(studentRequest.getAge());
        studentToSave.setEmail(studentRequest.getEmail());
        studentToSave.setSubject(studentRequest.getSubject());
        studentToSave.setRollNo(studentRequest.getRollNo());
        studentRepository.save(studentToSave);
        return studentToSave;
    }

    public Boolean deleteStudentById(Long id) {

        Boolean  isStudent= studentRepository.existsById(id);

        if(!isStudent){
            return false;
        }

      studentRepository.deleteById(id);
        return true;
    }
}
