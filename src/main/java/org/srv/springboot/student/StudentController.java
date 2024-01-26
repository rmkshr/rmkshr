package org.srv.springboot.student;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.srv.springboot.student.entity.Student;
import org.srv.springboot.student.studentsercvice.StudentService;

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
