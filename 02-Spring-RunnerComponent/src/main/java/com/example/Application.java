package com.example;

import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		// we will not call the runner component 
		//this SpringApplication.run method call the Runner Component one time only load it and call it when it is load ?
		// when it register in spring container how it will be register in spring container by adding the @Component 
		
		List<Integer> list = new LinkedList<>();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		
		int a = list.size()/2;
		
		System.out.println(list);
		
		System.out.println(a);
		
		list.add(a , 10);
		
		System.out.println(list);
		
	}

}
