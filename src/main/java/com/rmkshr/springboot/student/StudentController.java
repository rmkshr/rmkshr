package com.rmkshr.springboot.student;

import com.rmkshr.springboot.student.studentsercvice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ramkishore
 */
@RestController
@RequestMapping("/spring/v1")
public class StudentController {

    public final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/register")
    public void registerStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @PostMapping("/registernew")
    public void register(@RequestBody Student student) {
        studentService.addNewStudentDetail(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }
}
