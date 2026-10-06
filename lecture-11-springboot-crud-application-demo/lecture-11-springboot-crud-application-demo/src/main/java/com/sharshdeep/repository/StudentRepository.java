package com.sharshdeep.repository;

import com.sharshdeep.entitiy.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository -> only required when we write uor own custm queries
public interface StudentRepository extends JpaRepository<Student,Long> {

//    public Student saveStudent(Student studentRequest) {
//        // save to DB
//
//        return new Student(1L,"Computer Science","harshdeepsinghsaini2023@gmail.com",17,22 ,"Harshdeep Singh Saini");
//    }

}
