package com.example.runner;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MyAppRunner implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("hello welcome to Springboot");		
	if(args.containsOption("dark.mode")) {
		List<String> lst = args.getOptionValues("dark.mode");
		
		if(lst.get(0).equals("true")) {
		System.out.println("darkk mode is enable");
		}else {
			System.out.println("dark mode is disabled");
		}
	}else {
		System.out.println("the dark mode is disabled");
	}

	}
// java -jar target/ProjectName-1.1.jar --dark.mode=true   // it enable now
// java -jar target/ProjectName-1.1.jar --dark.mode=false  // we will get even now alsp becuase it have dark.mode  
}


