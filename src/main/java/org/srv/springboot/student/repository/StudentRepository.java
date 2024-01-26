package org.srv.springboot.student.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.srv.springboot.student.entity.Student;

/**
 * @author Ramkishore
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  Optional<Student> findStudentByEmail(String email);

  Optional<List<Student>> findAllStudentByEmail(String email);
}
