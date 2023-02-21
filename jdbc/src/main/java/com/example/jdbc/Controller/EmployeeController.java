package com.example.jdbc.Controller;

import com.example.jdbc.model.Employee;
import com.example.jdbc.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
     private EmployeeRepo employeeRepo;
  @GetMapping("/count")
    public int countEmployee(){
        return employeeRepo.count() ;
    }
    @GetMapping("/{id}")
    public Employee findById(@PathVariable long id){
        return employeeRepo.findById(id) ;
    }
    @GetMapping("")
    public List<Employee> findById(){
        return employeeRepo.findAll() ;
    }
}
