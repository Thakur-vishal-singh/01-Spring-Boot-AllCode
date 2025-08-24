package tech.vishal.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import tech.vishal.entity.CustomerEntity;
import tech.vishal.service.CustomerService;

@Component
public class CustomerRunner implements ApplicationRunner{

	@Autowired
	CustomerService service;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		saveAll();
		System.out.println("\n");
		
		System.out.println("#*#*#*".repeat(30));
		System.out.println("find the records which have the emil vishalrajput@gmail.com ::::");
		getEmail("vishalrajput@gmail.com");
		System.out.println("\n");
		
		System.out.println("#*#*#*".repeat(30));
		System.out.println("finf the records which have the this number 1234567890 ::::");
		findByNumber(1234567890L);
		System.out.println("\n");

		
		System.out.println("#*#*#*".repeat(30));
		System.out.println("find the records which have name vishal ::::");
		findByName("vishal");
		System.out.println("\n");

        System.out.println("#*#*#*".repeat(30));
        System.out.println("printing all the data :::::");
        printAll();
		System.out.println("\n");

		System.out.println("#*#*#*".repeat(30));
		System.out.println("getting all which name have the vish ::::");
		List<CustomerEntity> byNameHaveLetter = findByNameHaveLetter("vish");
		 byNameHaveLetter.forEach(s -> System.out.println(s));
		 
		 
		 
	}

	
	public void saveAll() {
		
		CustomerEntity insert = new CustomerEntity();
		insert.setEmail("vishalrajput@gmail.com");
		insert.setName("vishal rajput");
		insert.setNumber(1234567890L);
		
		CustomerEntity insert1 = new CustomerEntity();
		insert1.setEmail("vishalsingh@gmail.com");
		insert1.setName("vishal singh");
		insert1.setNumber(1234509876L);
		
		CustomerEntity insert2 = new CustomerEntity();
		insert2.setEmail("vishalthakur@gmail.com");
		insert2.setName("vishal thakur");
		insert2.setNumber(5432167890L);
		
		CustomerEntity insert3 = new CustomerEntity();
		insert3.setEmail("vishal@gmail.com");
		insert3.setName("vishal");
		insert3.setNumber(6789012345L);
		
		Iterable<CustomerEntity> saveDataAll = service.saveAll(Arrays.asList(insert,insert1,insert2,insert3));
		if(Objects.nonNull(saveDataAll)) {
			System.out.println("save successfully and getting all the data.....");
		saveDataAll.forEach(System.out::println);
		}
		else 
		System.out.println("don't have the records......");	
	}
	
	
	public List<CustomerEntity> findByNameHaveLetter(String name){
		return service.findNamelike(name);
	}
	
	public void findByNumber(Long number) {
		Optional<CustomerEntity> number2 = service.findNumber(number);
		number2.stream().forEach(s -> System.out.println(s));
	}
	
	public void getEmail(String email) {
		CustomerEntity email2 = service.findEmail(email);
		if(Objects.nonNull(email2)) {
			System.out.println("findByEmail  "+email+"  here the full detail ");
			System.out.println("id ::::"+email2.getCustomerId());
			System.out.println("Name ::::"+email2.getName());
			System.out.println("Number ::::"+email2.getNumber());
			System.out.println("Email ::::"+email2.getEmail());
		}else {
			System.out.println("Eamil not founded");
		}
	}
	
	public void printAll() {
		Iterable<CustomerEntity> byAll = service.findByAll();
		byAll.forEach(System.out::println);
		}
	
	public void findByName(String name) {
		CustomerEntity name2 = service.findName(name);
		if (Objects.nonNull(name2)) {
			System.out.println("findByName "+name+" here the full detail ");
			System.out.println("id ::::"+name2.getCustomerId());
			System.out.println("Name ::::"+name2.getName());
			System.out.println("Number ::::"+name2.getNumber());
			System.out.println("Email ::::"+name2.getEmail());
		}else {
			System.out.println("Named not founded");
		}
	}
	
}
