package com.example.jdbc.impl;

import com.example.jdbc.mapper.EmployeeMapper;
import com.example.jdbc.model.Employee;
import com.example.jdbc.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class EmployeeJDBCRepo implements EmployeeRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from employee", Integer.class);
    }

    @Override
    public Employee findById(long id) {
        return jdbcTemplate.queryForObject("select * from employee where id=?", new Object[]{id}
                ,new EmployeeMapper());
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("select * from employee ",new EmployeeMapper());
    }

    @Override
    public int insert(Employee employee) {
        return jdbcTemplate.update("insert into employee(id,name,salary) values (?,?,?)",new Object[]{employee.getID(),employee.getName(),employee.getSalary()});
    }

    @Override
    public int update(Employee employee) {
        return jdbcTemplate.update("update employee set  name=?,salary=?",new Object[]{employee.getName(),employee.getSalary()});

    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("delete from emplyee where id=?",new Object[]{id});

    }
}
