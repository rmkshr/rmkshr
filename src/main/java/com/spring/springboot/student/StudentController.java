package com.spring.springboot.student;

import com.spring.springboot.studentsercvice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spring/v1")
public class StudentController {

    public final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public List<Student> getStudents () {
        return studentService.getStudents();
    }

    @PostMapping("/register")
    public void registerStudent (@RequestBody Student student) {
            studentService.addNewStudent(student);
    }

    @PostMapping("/registernew")
    public void register (@RequestBody Student student) {
        studentService.addNewStudentDetail(student);
    }
}
