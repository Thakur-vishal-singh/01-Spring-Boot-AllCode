package tech.vishal.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import tech.vishal.Service.OrderService;
import tech.vishal.entity.OrderEntity;
import tech.vishal.entity.OrderStatus;
@Order(2)
@Component
public class MyAppRunner implements ApplicationRunner {

	@Autowired
	OrderService orderService;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		// when we are using the Long we should end the number with L if float then f like that all 
		OrderEntity order = new OrderEntity(19001L,101L,LocalDate.now(),OrderStatus.ORDERED);
		orderService.saveOrUpdate(order);
		System.out.println("Order Save Successfully");
		
		System.out.println("======================");
		
		OrderEntity getOrderId = orderService.getOrder(19001L);
		System.out.println("getting the specific :::::::");
		System.out.println(getOrderId);
		
		
		System.out.println("getting the all orders ::::::");
		Iterable<OrderEntity>  iterable = orderService.getAllOrders();
		iterable.forEach(ord -> System.out.println(ord));

		
		
	}

}
