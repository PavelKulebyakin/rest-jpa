package com.spring.practice.restjpa.service;

import com.spring.practice.restjpa.entity.Employee;
import com.spring.practice.restjpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultEmployeeService implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public DefaultEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = null;
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()) {                                           // Check if null
            employee = optional.get();
        }
        return employee;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllEmployeesByName(String name) {
        return employeeRepository.findAllByName(name);
    }
}
