package org.srv.springboot.student.studentsercvice;

import org.srv.springboot.student.repository.StudentRepository;
import org.srv.springboot.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Ramkishore
 */
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("User Already Exist");
        }
        studentRepository.save(student);
    }

    public void addNewStudentDetail(Student student) {
        Optional<List<Student>> studentOptionalList = studentRepository.findAllStudentByEmail(student.getEmail());
        for (Student studentObject : studentOptionalList.get()) {
            System.out.println(studentObject.toString());
        }

    }

    public void deleteStudent(Long studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new IllegalStateException("User does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException
                ("student with id " + studentId + " does not exist"));
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            student.setEmail(email);
        }
    }
}
