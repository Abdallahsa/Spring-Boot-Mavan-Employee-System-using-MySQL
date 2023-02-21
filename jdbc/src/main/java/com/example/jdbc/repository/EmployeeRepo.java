package com.example.jdbc.repository;

import com.example.jdbc.model.Employee;
import org.springframework.stereotype.Component;


import java.util.List;
@Component
public interface EmployeeRepo {
    int count();
    Employee findById(long id);
    List<Employee> findAll();
    int insert(Employee employee);
    int update(Employee employee);
    int delete(Long id);
}
