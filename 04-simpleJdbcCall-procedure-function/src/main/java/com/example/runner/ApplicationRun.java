package com.example.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.service.ApplicationService;

@Component
public class ApplicationRun implements ApplicationRunner {

	@Autowired
	ApplicationService service;
	
	
	// all name argument will store in the application argument
	@Override         
	public void run(ApplicationArguments arg)throws Exception{
		
		//  arg.getOptionValues(null); it return type is List<String> 
		// List<String> value = arg.getOptionValues(null);
		// here we store String and when we give any input to the java it will store as the string type
		// we are sending integer type so we need to convert into the string type so we will use here paserInt 
		// Integer.parseint() ==> convert string to integer 
		List<String> lst = arg.getOptionValues("empId"); // it read from the cmd and argument and store in the ApplicationArgument 
		
		String str = lst.get(0);
		
		int empId = Integer.parseInt(str);
		
		service.redBound(empId);	
		
	}
	
	
}
