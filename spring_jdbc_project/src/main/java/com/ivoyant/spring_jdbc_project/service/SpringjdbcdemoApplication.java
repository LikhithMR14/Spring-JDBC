package com.ivoyant.spring_jdbc_project.service;

import com.ivoyant.spring_jdbc_project.config.JdbcConfig;
import com.ivoyant.spring_jdbc_project.dao.StudentDao;
import com.ivoyant.spring_jdbc_project.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class SpringjdbcdemoApplication {

	public static void main(String[] args) {
		System.out.println("program Started...");

		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        Student setStudent= new Student();
        setStudent.setId(12);
        setStudent.setEmail("example1@gmail.com");
        setStudent.setPassword("1221");
        setStudent.setUsername("harsha");

        int res1 = studentDao.insert(setStudent);
        System.out.println("Student added " +res1);

        setStudent.setId(20);
        setStudent.setEmail("example2@gmail.com");
        setStudent.setPassword("1234");
        setStudent.setUsername("likhith");

        studentDao.insert(setStudent);

        Student student = studentDao.getStudentId(12);
        System.out.println(student);


		List<Student> allStudents = studentDao.getAllStudents();
		for (Student s : allStudents) {
			System.out.println(s);
		}

        int delete = studentDao.deleteId(12);
        System.out.println("deleted rows"+delete);


        Student changeStudent = new Student();
        changeStudent.setId(10);
        changeStudent.setUsername("asif");
        int res3 = studentDao.changeId(changeStudent);


        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);

        String query="insert into college(id,username,email,password) values(?,?,?,?)";

        int i = template.update(query,14, "raju", "raju@gmail.com", "12345");
        System.out.println("number of record inserted " +i);
        //SpringApplication.run(SpringjdbcdemoApplication.class, args);
	}

}
