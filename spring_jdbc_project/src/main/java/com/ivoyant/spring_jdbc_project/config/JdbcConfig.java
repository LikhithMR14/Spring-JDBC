package com.ivoyant.spring_jdbc_project.config;




import com.ivoyant.spring_jdbc_project.dao.StudentDao;
import com.ivoyant.spring_jdbc_project.dao.StudentDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

//------------- jdbcConfigfile insted of xml file----------
@Configuration
public class JdbcConfig {
    @Bean("ds")
    public DataSource getDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5432/springJDBC");
        ds.setUsername("postgres");
        ds.setPassword("1234");
        return ds;
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate getTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }

    @Bean("studentDao")
    public StudentDao getStudentDao() {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        studentDao.setJdbcTemplate(getTemplate());
        return studentDao;

    }


}
