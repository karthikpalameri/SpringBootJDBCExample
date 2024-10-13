package com.jdbcexample.jdbcexample.repo;

import com.jdbcexample.jdbcexample.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s) {
        System.out.println("StudenRepo save method called.");

        String sql = "insert into Student (rollno, name, marks) values (?,?, ?)";
        int rowsAffected = jdbc.update(sql, s.getRollno(), s.getName(), s.getMarks());
        System.out.println("rowsAffected = " + rowsAffected);
    }

    public List<Student> findAll() {
        System.out.println("StudenRepo findAll method called.");
        String sql = "select * from student";

        RowMapper<Student> rowmapper = (rs, rowNum) -> {
            Student s = new Student();
            s.setRollno(rs.getInt("rollno"));
            s.setName(rs.getString("name"));
            s.setMarks(rs.getInt("marks"));
            return s;
        };

        return jdbc.query(sql, rowmapper);
    }
}
