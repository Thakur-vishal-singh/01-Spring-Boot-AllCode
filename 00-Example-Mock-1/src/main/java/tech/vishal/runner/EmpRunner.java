package tech.vishal.runner;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import tech.vishal.Entity.EmpEntity;
import tech.vishal.service.EmpService;


@Component
public class EmpRunner implements ApplicationRunner {

	@Autowired
	EmpService service;
	
	@Autowired
	EmpEntity empEntity;
	
	@Override
	public void run(ApplicationArguments args) {
		
		service.creatTable();
	    System.out.println("Table is create !");

	    
	    EmpEntity emp = new EmpEntity(1,"ujwal","ujwal@gmail.com");
		if(emp != null) 
		{
	    service.save(emp);
	    System.out.println("Success");
		}else{
			System.out.println("somrthing is worng here ");
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the empId to find it  ::::");
		int empId = sc.nextInt();
		service.findEmpById(empId);
		
		sc.nextLine();
		
		
		System.out.println("enter the email to find it ::::");
		String email = sc.nextLine();
		service.findByEmail(email);
		
		
	
		
	}
}
