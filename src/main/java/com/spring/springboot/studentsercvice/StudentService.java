package com.spring.springboot.studentsercvice;

import com.spring.springboot.repository.StudentRepository;
import com.spring.springboot.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

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
        if(studentOptional.isPresent()){
            throw new IllegalStateException("User Already Exist");
        }
        studentRepository.save(student);
    }

    public void addNewStudentDetail(Student student) {
        Optional<List<Student>> studentOptionalList = studentRepository.findAllStudentByEmail(student.getEmail());
        for(Student studentObject : studentOptionalList.get()){
            System.out.println(studentObject.toString());
        }

    }
}
