package com.ivoyant.spring_jdbc_project.dao;



import com.ivoyant.spring_jdbc_project.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import java.util.List;
public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;
    @Override
    public int insert(Student student) {
        String query="insert into college (id,username,email,password) values(?,?,?,?)";
        int res= this.jdbcTemplate.update(query, student.getId(), student.getUsername(), student.getEmail(),student.getPassword());
        return res;
    }

    @Override
    public int changeId(Student student) {
        String query = "update college set username =? where id=?";
        int res=this.jdbcTemplate.update(query,student.getUsername(),student.getId());
        return res;
    }

    @Override
    public int deleteId(int studentId) {
        String query ="delete from college where id=?";
        int res = this.jdbcTemplate.update(query, studentId);
        return res;
    }

    @Override
    public Student getStudentId(int studentId) {
        String query = "select * from college where id=?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);

        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        String query = "select * from college";
        List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
        return students;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
