package tech.vishal.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.Setter;
import tech.vishal.entity.OrderEntity;
import tech.vishal.service.OrderService;


@Component
public class OrderRunner implements ApplicationRunner {
	
	
	@Autowired
	@Setter
	OrderService orderService;
	
	
	
	@Override
	public void run(ApplicationArguments args) {
	
		System.out.println("Getting all the customer id between 1L 20000L");
		List<OrderEntity> allCustomerBetween = orderService.getAllCustomerBetween(1L, 105L);
		allCustomerBetween.forEach(s -> System.out.println(s));
		
		System.out.println("====".repeat(20));
		
		
		System.out.println("Getting all the customer id ::: 1L");
		List<OrderEntity> allCustomerId = orderService.getAllCustomerId(1L);
		allCustomerId.forEach(s -> System.out.println(s));
		System.out.println("====".repeat(20));

		
		System.out.println("getting the customer id :::: 105");
		List<OrderEntity> customerIdContaine = orderService.getCustomerId(105L);
		System.out.println("fectehed Records ::::"+customerIdContaine.size());
		customerIdContaine.forEach(s -> System.out.println(s));
		System.out.println("====".repeat(20));

		
	}
	
	
}
