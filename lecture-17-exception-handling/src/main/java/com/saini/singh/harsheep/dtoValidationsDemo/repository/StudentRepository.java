package com.saini.singh.harsheep.dtoValidationsDemo.repository;

import com.saini.singh.harsheep.dtoValidationsDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
