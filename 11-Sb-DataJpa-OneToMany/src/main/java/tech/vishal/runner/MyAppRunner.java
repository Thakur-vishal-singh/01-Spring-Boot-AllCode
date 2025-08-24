package tech.vishal.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import tech.vishal.entity.Customer;
import tech.vishal.entity.Order;
import tech.vishal.entity.OrderStatus;
import tech.vishal.service.CustomerService;


@Component
public class MyAppRunner implements ApplicationRunner {

	@Autowired
	CustomerService service;
	 					
// 1) we use this @Transactional here because when we don't use it and try to fetch the data from db it close after 
//the customer is done not wait for the orders so we need to use this @Transacational to tell that make connection until this method run   
//2) @Transactional // this @Transactional is from the springframwork.bean   // where should we called it ?  where we are calling the method which have to use the parent with child also with LAZY  . 
	@Override
	public void run(ApplicationArguments args) throws Exception {
		saveCustomerAndOrders();
		
	loadCustomer(1L);
	
	System.out.println("====".repeat(30));
	
	loadCustomer(2L);
	
	System.out.println("====".repeat(30));

	deleteCustomerById(2L);
	
	}
	
	
	
	
	public void saveCustomerAndOrders() {
	Customer customer = new Customer();
		
		customer.setName("jhon");
		customer.setNumber(123456789L);
		
		List<Order> orders = Arrays.asList(
				// in the order we don't have the auto generated so we have to give here all
				new Order(190076L,LocalDate.of(2025, 04, 06),OrderStatus.ORDERED),
				new Order(148870L, LocalDate.of(2024, 04, 07),OrderStatus.PROCESSED),
				new Order(133465L, LocalDate.of(2025, 04, 02),OrderStatus.DELIVERED),
				new Order(120021L, LocalDate.of(2025, 04, 05),OrderStatus.CANCELED),
				new Order(150021L, LocalDate.of(2025, 04, 06),OrderStatus.REFUNDED)				
				);
		customer.setOrders(orders);
		 customer = service.saveCustomer(customer);

		System.out.println("The Customer Is inserted with his orders to the Database");
		System.out.println("The customer id is :"+customer.getId());
		System.out.println("====".repeat(30));
		
		Customer customer2 = new Customer();
		
		customer2.setName("vickey");
		customer2.setNumber(987654321L);
		
		List<Order> orders2 = Arrays.asList(
				// in the order we don't have the auto generated so we have to give here all
				new Order(19007L,LocalDate.of(2025, 05, 06),OrderStatus.ORDERED),
				new Order(14887L, LocalDate.of(2024, 05, 02),OrderStatus.PROCESSED),
				new Order(13346L, LocalDate.of(2025, 05, 07),OrderStatus.DELIVERED),
				new Order(12002L, LocalDate.of(2025, 05, 03),OrderStatus.CANCELED),
				new Order(15002L, LocalDate.of(2025, 05, 07),OrderStatus.REFUNDED)				
				);
		customer2.setOrders(orders2);
		
		customer2 = service.saveCustomer(customer2);
		
		System.out.println("The Customer2 Is inserted with his orders2 to the Database");
		System.out.println("The customer id is :"+customer2.getId());
		System.out.println("====".repeat(30));
		
	}
	
	
	public void loadCustomer(Long id) {
		Customer customer = service.fetchCustomerId(id);
	   System.out.println("number ::"+customer.getId()+" name  ::"+customer.getName()+" number  ::"+customer.getNumber());// here not loaded the orders we have to load it 
	
	   List<Order> order = customer.getOrders();// here when we called then it loaded  so it lazy load when we called it it load before it will not load 
	   order.forEach(System.out::println);
	}
	
	public void deleteCustomerById(long id) {
		service.deleteCustomerById(id);
	}
	
	
	
	
}
/*
fetch = fetchType.LAZY; 

note : here look there is not order table query is selected when we called it 

Hibernate: 
select
   c1_0.id,
   c1_0.name,
   c1_0.number 
from
   customer c1_0 
where
   c1_0.id=?
number ::1 name  ::jhon number  ::123456789




fetch = fetchType.EAGER

note: look here it select the order also so it load the parent with the child 
and here we no need to write the @Transactional 

 Hibernate: 
select
   c1_0.id,
   c1_0.name,
   c1_0.number,
   o1_0.customer_id,
   o1_0.order_id,
   o1_0.date_purchased,
   o1_0.status 
from
   customer c1_0 
left join														//	>>>> look here it selected the order also 
   orders o1_0 
       on c1_0.id=o1_0.customer_id 
where
   c1_0.id=?
number ::1 name  ::jhon number  ::123456789

*/