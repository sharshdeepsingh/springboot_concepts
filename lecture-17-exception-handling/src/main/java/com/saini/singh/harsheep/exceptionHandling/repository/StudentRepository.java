package com.saini.singh.harsheep.exceptionHandling.repository;

import com.saini.singh.harsheep.exceptionHandling.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
