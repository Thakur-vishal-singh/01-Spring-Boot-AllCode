package tech.vishal.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import tech.vishal.entity.CustomerEntity;
import tech.vishal.repo.CustomerRepo;
import tech.vishal.service.CustomerService;

@Component
public class CustomerRunner implements ApplicationRunner {

	@Autowired CustomerService service;
	
	@Autowired CustomerRepo repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		CustomerEntity insert = new CustomerEntity();
		insert.setName("thakur vishal");
		insert.setEmail("thakurvishal@gmail.com");
		insert.setNumber(6789054321L);
		
		CustomerEntity insert2 = new CustomerEntity();
		insert2.setName("thakur vishal singh");
		insert2.setEmail("thakurvishalsingh@gmail.com");
		insert2.setNumber(6789067890L);

		List<CustomerEntity> data = repo.saveAll(Arrays.asList(insert, insert2));
		data.forEach(System.out::println);
		
		System.out.println("#>#>".repeat(30));
		System.out.println("The for the user email and password is ::::::");
		login("thakurvishal@gmail.com","thakur vishal");
		
		System.out.println("#>#>".repeat(30));
		System.out.println("The for the user number is ::::::");
		getNumberInfo(6789054321L);
		
	}


	public void login(String email, String password) {
		CustomerEntity login = service.login(email, password);
		
		System.out.println(" CustomerId ::::"+login.getCustomerId());
		System.out.println("Name ::::"+login.getName());
		System.out.println("phone number ::::"+login.getNumber());
		System.out.println("Email ::::"+login.getEmail());

	}
	
	
	public void getNumberInfo(Long number) {
		List<CustomerEntity> numberData = service.getNumberData(number);
			numberData.forEach(s -> System.out.println(s));
	}
	
}
