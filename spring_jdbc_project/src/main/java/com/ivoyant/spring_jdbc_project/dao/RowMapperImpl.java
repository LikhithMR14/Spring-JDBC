package com.ivoyant.spring_jdbc_project.dao;



import com.ivoyant.spring_jdbc_project.entity.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImpl implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt(1));
        student.setUsername(rs.getString(2));
        student.setEmail(rs.getString(3));
        student.setPassword(rs.getString(4));
        return student;
    }
}
