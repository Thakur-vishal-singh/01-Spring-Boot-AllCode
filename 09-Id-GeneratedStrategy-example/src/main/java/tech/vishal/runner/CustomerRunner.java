package tech.vishal.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import tech.vishal.entity.CustomerEntity;
import tech.vishal.repo.CustomerRepo;
import tech.vishal.service.CustomerService;

@Component
public class CustomerRunner implements ApplicationRunner{

	
	@Autowired
	CustomerService service;
	
	
	@Autowired CustomerRepo repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
			
//		CustomerEntity start = new CustomerEntity();
//		
//		start.setName("vishal"); start.setEmail("vishal@gmail.com"); 
//		start.setNumber(123456789L);
//		
//		CustomerEntity start1 = new CustomerEntity();
//		start.setName("vishal singh"); start.setEmail("vishalsingh@gmail.com"); 
//		start.setNumber(987654321L);
//		
		
		CustomerEntity customer1 = new CustomerEntity();
        customer1.setName("Vishal");
        customer1.setEmail("vishal@gmail.com");
        customer1.setPhNumber(123456789L);

        CustomerEntity customer2 = new CustomerEntity();
        customer2.setName("Vishal Singh");
        customer2.setEmail("vishalsingh@gmail.com");
        customer2.setPhNumber(987654321L);
        
		List<CustomerEntity> saveCustomer = repo.saveAll(Arrays.asList(customer1, customer2));  
		
		for(CustomerEntity saveEx : saveCustomer) {
			System.out.println("name :::"+saveEx.getName()+"\nemail ::::"+saveEx.getEmail()+"\nNumber ::::"+saveEx.getPhNumber());
		}//look i have oracle sql 11 and now i'm facing this issue   
		
		List<CustomerEntity> ex = saveCustomer.stream().filter(s -> "vishal@gmail.com".equals(s.getEmail())).collect(Collectors.toList());
		System.out.println(ex);
		
		
//        System.out.println("\n Fetching without resultClass:");
//		List<Object[]> get = repo.getAll();
//		get.forEach(row ->{    
//			System.out.println("id: " + row[0] + " | name: " + row[1] + " | email: " + row[2]+" | Number "+ row[3]);
//		});
//		for(Object[] get1 : get) {
//		    System.out.println("id: " + get1[0] + " | name: " + get1[1] + " | email: " + get1[2] + " | Number: " + get1[3]);
//		}
		
			List<CustomerEntity> get = repo.getAll();
			get.forEach(row ->{    
				System.out.println(row);
			});
		
	}

	
	
}
