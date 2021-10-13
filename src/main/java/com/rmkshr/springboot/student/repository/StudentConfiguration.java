package com.rmkshr.springboot.student.repository;

import com.rmkshr.springboot.student.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * @author Ramkishore
 */
@Configuration
public class StudentConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student ram = new Student("Ram", LocalDate.of(1993, Month.FEBRUARY, 2), "ramkishore@gmail.com");
            Student sugan = new Student("Suganya", LocalDate.of(1994, Month.DECEMBER, 14), "suganya@gmail.com");
            Student vihaan = new Student("Vihaan", LocalDate.of(2021, Month.AUGUST, 25), "vihaan@gmail.com");
            studentRepository.saveAll(List.of(ram, sugan, vihaan));
        };
    }
}
