package com.jdbcexample.jdbcexample;

import com.jdbcexample.jdbcexample.model.Student;
import com.jdbcexample.jdbcexample.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class JdbcexampleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JdbcexampleApplication.class, args);
        System.out.println("Hello World.");

        Student s = context.getBean(Student.class);
        s.setRollno(2);
        s.setName("kk2");
        s.setMarks(100);
        System.out.println("s = " + s);

        StudentService service = context.getBean(StudentService.class);
        service.addStudent(s);

        List<Student> students = service.getStudents();
        System.out.println("students = " + students);

    }

}
