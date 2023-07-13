package com.spring.practice.restjpa;

import com.spring.practice.restjpa.entity.Employee;
import com.spring.practice.restjpa.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class RestJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestJpaApplication.class, args);
	}

	@Bean
	@Profile("test")
	public CommandLineRunner dataLoader(EmployeeService service) {
		return args -> {
			service.saveEmployee(new Employee("Ivan", "Makarov", "IT", 100000));
			service.saveEmployee(new Employee("Vladimir", "Boronin", "IT", 80000));
			service.saveEmployee(new Employee("Anastasiya", "Volkova", "HR", 80000));
		};
	}
}
