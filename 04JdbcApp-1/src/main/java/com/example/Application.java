package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entity.Employee;
import com.example.repo.EmployeeReposotroy;

@SpringBootApplication
public class Application {

	
	static EmployeeReposotroy empRepo;
	
	public Application(EmployeeReposotroy empRepo){
		this.empRepo=empRepo;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		Employee exmple = new Employee(5,"vishu",50000.0,14,24);
		
		empRepo.save(exmple);
		
		empRepo.findById(2);
	
		
	}

}
