package com.spring.practice.restjpa.repository;

import com.spring.practice.restjpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository
        extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByName(String name);
}
