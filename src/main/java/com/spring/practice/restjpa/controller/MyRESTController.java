package com.spring.practice.restjpa.controller;

import com.spring.practice.restjpa.entity.Employee;
import com.spring.practice.restjpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    private final EmployeeService employeeService;

    @Autowired
    public MyRESTController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employee")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);              /// ????
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/employee/{id}")
    private String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted.";
    }

    @GetMapping("/employee/name/{name}")
    private List<Employee> showAllEmployeesByName(@PathVariable String name){
        return employeeService.findAllEmployeesByName(name);
    }
}
