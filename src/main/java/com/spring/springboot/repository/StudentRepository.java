package com.spring.springboot.repository;

import com.spring.springboot.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentByEmail(String email);
    Optional<List<Student>> findAllStudentByEmail(String email);
}
