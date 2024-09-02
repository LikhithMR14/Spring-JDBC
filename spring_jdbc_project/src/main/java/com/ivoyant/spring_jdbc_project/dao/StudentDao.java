package com.ivoyant.spring_jdbc_project.dao;



import com.ivoyant.spring_jdbc_project.entity.Student;

import java.util.List;

public interface StudentDao {
    public  int insert(Student student);

    public int changeId(Student student);

    public  int deleteId(int studentId);

    public Student getStudentId(int studentId);

    public List<Student> getAllStudents();
}
