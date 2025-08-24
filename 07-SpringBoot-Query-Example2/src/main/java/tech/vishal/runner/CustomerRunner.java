package tech.vishal.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import tech.vishal.entity.CustomerEntity;
import tech.vishal.repo.CustomerRepo;
import tech.vishal.service.CustomerService;


@Component
public class CustomerRunner implements ApplicationRunner{

	
	CustomerService service;

	CustomerRepo repo;
	
	@Autowired
	CustomerRunner(CustomerService service, CustomerRepo repo){
		this.repo=repo;
		this.service=service;
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		
		
	CustomerEntity name = service.customerIsName("vishal");
	System.out.println("Id ::::"+name.getCustomerId()+"  Name ::::"+name.getName()+"  phoneNO ::::"+name.getPhoneNo()+"  Email ::::"+name.getEmailId());
	
	String customerLogin = service.CustomerLogin("vishal", "vishal");
	System.out.println(customerLogin);
		
		
	}
	
}
