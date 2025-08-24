package tech.vishal.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import tech.vishal.entity.CustomerEntity;
import tech.vishal.service.CustomerService;


//@Component
public class CustomerRunner2 implements ApplicationRunner {

	@Autowired
	CustomerService service;
	
	
	 @Override
	public void run(ApplicationArguments args) throws Exception {
		
			List<CustomerEntity> insert = Arrays.asList( 
//public CustomerEntity(String name, String phoneNo, String emailId, String password) {
			new CustomerEntity("sudha","123456","sudha@gamil.com","sudha@143"),
			new CustomerEntity("sudha singh","12345","sudhasingh@gamil.com","sudhsingh@143"),
			new CustomerEntity("sudha thakur","123456789","sudhathakur@gamil.com","sudhathakur@143"),
			new CustomerEntity("sudha rajput","123456987","sudharajput@gamil.com","sudharajput@143")
			);
		 
		 if(service.insertCustomer(insert)!= null) {
			 insert.forEach(i -> System.out.println(i));
		 }
		 
}
}