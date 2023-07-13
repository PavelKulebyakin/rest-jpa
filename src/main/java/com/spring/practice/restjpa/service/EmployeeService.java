package com.spring.practice.restjpa.service;

import com.spring.practice.restjpa.entity.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployee(Long id);

    Employee saveEmployee(Employee employee);

    void deleteEmployee(Long id);

    List<Employee> findAllEmployeesByName(String name);
}
