package com.example.jdbc.javaconfig;

import com.example.jdbc.model.Employee;
import com.example.jdbc.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Config implements ApplicationRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
    jdbcTemplate.execute("drop table IF EXists employee");
    jdbcTemplate.execute("create table employee (id serIal,name varchar(250),salary numeric(15,2))");
    if(employeeRepo.count()==0){
        employeeRepo.insert(new Employee(20L,20,"abdallah"));
        employeeRepo.insert(new Employee(30L,200,"saleh"));
        employeeRepo.insert(new Employee(40L,240,"sayed"));
    }
    }
}
