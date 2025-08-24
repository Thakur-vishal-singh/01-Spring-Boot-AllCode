package com.example.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.service.EmpService;

@Component
public class EmpRunner implements ApplicationRunner
{

	@Autowired
	EmpService empService;
	
	
	@Override
	public void run(ApplicationArguments args) {
	    System.out.println("ApplicationRunner is executing...");
		
		List<String>  example = args.getOptionValues("empId");
		
		if(example.isEmpty() || example == null) {
			System.out.println("No EmpId Provided");
			return;
		}
		
		
	    String value = example.get(0);
		
	    int empId = Integer.parseInt(value);
	    System.out.println("Calling service with empId: " + empId);
	    empService.readBonus(empId);
//	    empService.redBound(empId);
	    
	}
	
}