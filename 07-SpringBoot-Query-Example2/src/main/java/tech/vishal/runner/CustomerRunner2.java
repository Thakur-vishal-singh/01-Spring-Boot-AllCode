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

//@Component
public class CustomerRunner2 implements ApplicationRunner{

	CustomerService service;

	CustomerRepo repo;
	
	@Autowired
	CustomerRunner2(CustomerService service, CustomerRepo repo){
		this.repo=repo;
		this.service=service;
	}
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<CustomerEntity> insert = Arrays.asList(
				new CustomerEntity("vishal","7416520523","vishal@gmail.com","vishal"),
				new CustomerEntity("vishal singh","7416532520","vishalsingh@gmail.com","vishal@143"),
				new CustomerEntity("vishal Rajput","9550523153","vishalrajput@gmail.com","vishalrajput@143")
				);
		service.saveAllCustomerData(insert);
//		System.out.println(service.saveAllCustomerData(insert));
//					|| we can print direct but that is not right approach we should use the method to print
		System.out.println("*#*#".repeat(30));
		System.out.println("getting all the reocords :::::::");
		Iterable<CustomerEntity> getAll =  service.getAllTheRecordes();
		getAll.forEach(g -> System.out.println(g));
		
	}

	
	
	
	
}
