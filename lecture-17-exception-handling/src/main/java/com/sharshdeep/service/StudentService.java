package com.sharshdeep.service;

import com.sharshdeep.dto.request.CreateStudentRequestDto;
import com.sharshdeep.dto.request.UpdateStudentRequestDto;
import com.sharshdeep.dto.response.CreateStudentResponseDto;
import com.sharshdeep.dto.response.UpdateStudentResponseDto;
import com.sharshdeep.entitiy.Student;
import com.sharshdeep.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<CreateStudentResponseDto> getAllStudents() {

        List<Student> studentList = studentRepository.findByDeletedFalse();
        List<CreateStudentResponseDto> studentListDto = new ArrayList<>();
        for(Student s: studentList){
            studentListDto.add(mapToDto(s));
        }
        return studentListDto;
    }

    public CreateStudentResponseDto createStudent(CreateStudentRequestDto studentReqDto) {

     Student student =mapToEntity(studentReqDto);

     student.setCreatedAt(LocalDateTime.now());
     student.setUpdatedAt(LocalDateTime.now());

     Student studentResponse=studentRepository.save(student);

     return mapToDto(studentResponse);
    }

    private CreateStudentResponseDto mapToDto(Student student) {
        CreateStudentResponseDto responseDto= new CreateStudentResponseDto();
        responseDto.setId(student.getId());
        responseDto.setName(student.getName());
        responseDto.setAge(student.getAge());
        responseDto.setRollNo(student.getRollNo());
        responseDto.setEmail(student.getEmail());
        responseDto.setMessage("Student Record has been created");
        responseDto.setCreateAt(student.getCreatedAt());
        responseDto.setSubject(student.getSubject());
        responseDto.setUpdatedAt(student.getUpdatedAt());

        return responseDto;
    }

    private Student mapToEntity(CreateStudentRequestDto studentReqDto) {
        Student student=new Student();
        student.setName(studentReqDto.getName());
        student.setAge(studentReqDto.getAge());
        student.setEmail(studentReqDto.getEmail());
        student.setRollNo(studentReqDto.getRollNo());
        student.setSubject(studentReqDto.getSubject());

        student.setDeleted(false);

        return student;

        // we will use builder design pattern
    }

    public CreateStudentResponseDto getStudentById(Long studentId) {
        Optional<Student> studentResponse = studentRepository.findByIdAndDeletedFalse(studentId);

        if(studentResponse.isEmpty()){
            return null;
        }
        return mapToDto(studentResponse.get());
    }

    public UpdateStudentResponseDto updateStudentById(Long studentId, UpdateStudentRequestDto studentRequest) {

        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedFalse(studentId);
        if (existingStudent.isEmpty()) {
            return null;
        }
        Student studentToSave = existingStudent.get();

        studentToSave.setDeleted(false);
        studentToSave.setName(studentRequest.getName());
        studentToSave.setAge(studentRequest.getAge());
//        studentToSave.setEmail(studentRequest.getEmail());
        studentToSave.setSubject(studentRequest.getSubject());
        studentToSave.setRollNo(studentRequest.getRollNo());
        studentToSave.setUpdatedAt(LocalDateTime.now());
        Student savedStudent =studentRepository.save(studentToSave);

        return mapToUpdateDto(savedStudent);
    }

    private UpdateStudentResponseDto mapToUpdateDto(Student savedStudent) {
        UpdateStudentResponseDto responseDto= new UpdateStudentResponseDto();
        responseDto.setId(savedStudent.getId());
        responseDto.setName(savedStudent.getName());
        responseDto.setAge(savedStudent.getAge());
        responseDto.setRollNo(savedStudent.getRollNo());
        responseDto.setEmail(savedStudent.getEmail());
        responseDto.setMessage("Student Record has been created");
//        responseDto.setCreateAt(savedStudent.getCreatedAt());
        responseDto.setSubject(savedStudent.getSubject());
        responseDto.setUpdatedAt(savedStudent.getUpdatedAt());

        return responseDto;
    }

    public Boolean deleteStudentById(Long id) {

        Boolean isStudent = studentRepository.existsById(id);

        if (!isStudent) {
            return false;
        }

        studentRepository.deleteById(id);
        return true;
    }


    public Boolean softDeleteStudentById(Long id) {
Optional<Student> existingStudent=studentRepository.findByIdAndDeletedFalse(id);
        if(existingStudent.isEmpty()){
            return false;
        }

       Student studentToSave= existingStudent.get();
studentToSave.setDeleted(true);
studentRepository.save(studentToSave);

return true;
    }
}
