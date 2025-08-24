package tech.vishal.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import tech.vishal.entity.OrderEntity;
import tech.vishal.entity.OrderStatus;
import tech.vishal.service.OrderService;

@Component
public class OrderRunner implements ApplicationRunner{

	
	@Autowired
	OrderService service;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
	
	List<OrderEntity> insert = Arrays.asList(
			
			new OrderEntity(1L,1L,OrderStatus.DELIVERED,LocalDate.now()),
			new OrderEntity(2L,1L,OrderStatus.CANCELED,LocalDate.now()),
			new OrderEntity(3L,2L,OrderStatus.ORDERED,LocalDate.now()),
			new OrderEntity(4L,3L,OrderStatus.PROCESSED,LocalDate.now()),
			new OrderEntity(5L,2L,OrderStatus.REFUNDED,LocalDate.now())
			);
		
	if(!service.saveAllOrderDate(insert).isEmpty()) {
		System.out.println("all Save success fully");
	}
	
	
	System.out.println("$$$$$".repeat(30));
	System.out.println("this all query which is cancled ::::");
	List<OrderEntity> findCancled = service.getOrderStatus(OrderStatus.CANCELED);
	findCancled.forEach(s -> System.out.println(s));
	
	
	System.out.println("####".repeat(30));
	System.out.println("all the customer who id is ::: 2 or order on 2025-3-22");
	List<OrderEntity> idOrDate =service.getByCustomerIdOrOrderDate(2L, LocalDate.of(2025, 3, 22));
	idOrDate.forEach(s -> System.out.println(s));
	
	
	List<Object[]> count = service.getAllCustomerOrderCount();
	count.forEach(k -> System.out.println(k[0]+" :::: "+k[1]));
		
	
	
	}
}
