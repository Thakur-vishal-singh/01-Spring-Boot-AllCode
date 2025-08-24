package tech.vishal.runner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import tech.vishal.service.CustomerService;

@Component
public class CustomerRunner implements ApplicationRunner {

	@Autowired
	CustomerService service;
	
	@Value("${find.id.is}")
	private Integer findId;
	
	@Value("${find.date.is}")
	private String findDate;
	
	
	 @Override
	public void run(ApplicationArguments args) throws Exception {
		
	
		 
//		 service.findByIdOrDate(4, LocalDate.of(2025, 4, 6));
		 
		 
		 LocalDate date = parseDate(findDate);
		 
		 service.findByIdOrDate(findId,date);

		 
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter the email and password to login ::::");
		 String email = sc.nextLine();
		 String password = sc.nextLine();
		 System.out.println(service.login(email,password));
		 
		 
		 System.out.println("Enter the number to find it ::::");
		 String number = sc.nextLine();
		 System.out.println(service.findByNumber(number));
		 
		 
	}
	
	private LocalDate parseDate(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(dateString, formatter);
	}
	
}




//package tech.vishal.runner;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import tech.vishal.entity.CustomerEntity;
//import tech.vishal.service.CustomerService;
//
//@Component
//public class CustomerRunner implements ApplicationRunner {
//
//    private final CustomerService service;
//
//    @Autowired
//    public CustomerRunner(CustomerService service) {
//        this.service = service;
//    }
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        // Insert customer data
//        List<CustomerEntity> insert = Arrays.asList(
//            new CustomerEntity("vishal", "7416520523", "vishal@gmail.com", "vishal"),
//            new CustomerEntity("vishal singh", "7416520523", "vishalsingh@gmail.com", "vishal@143"),
//            new CustomerEntity("vishal Rajput", "9550523153", "vishalrajput@gmail.com", "vishalrajput@143")
//        );
//
//        service.insertCustomer(insert);
//
//        // Retrieve customer by name
//        List<CustomerEntity>  customer = service.customerIsName("vishal");
//       customer.forEach(s -> System.out.println(s));
//       
//    }
//}