package com.example.bean;

import org.springframework.stereotype.Component;

@Component    // The generic stereotype annotation for any Spring-managed component.  
public class HelloBean {

	public void firstHello() {
		System.out.println("hello everyone how are you this is Springboot class our.....");
	}

	
	public void helloBean() {
		System.out.println("hello from HelloBean method");
	}

}
