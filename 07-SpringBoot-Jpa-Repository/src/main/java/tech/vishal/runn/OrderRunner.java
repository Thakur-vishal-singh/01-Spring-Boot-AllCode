package tech.vishal.runn;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import tech.vishal.entity.OrderEntity;
import tech.vishal.service.OrderService;


@Component 
public class OrderRunner implements ApplicationRunner{

	
	OrderService orderService;
	
	@Autowired
	public OrderRunner(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<String> getId =args.getOptionValues("empId");
		String value = getId.get(0);
		
		Long orderId = Long.parseLong(value);
		Optional<OrderEntity> specificId = orderService.getSpecificId(orderId);
		System.out.println(specificId);
		
		System.out.println("getting the orderId with Args argument ::::");
		Optional<OrderEntity> specificId1 = orderService.getSpecificId(1L);
		System.out.println(specificId1);
	
		System.out.println("Getting the all customer Id ::::");
		
		List<OrderEntity> order = orderService.getCustomerId(orderId);
		System.out.println(order);
		
		
		System.out.println("getting all the date greater then 2025 2 15 ::::");
		List<OrderEntity> greaterThen =orderService.getOrderGreaterThen(LocalDate.of(2025, 03, 25));
		greaterThen.forEach(s -> System.out.println(s));
		
		System.out.println("gettting the all ids ::::");
		List<OrderEntity> gettingAllOrders = orderService.gettingAll();
		gettingAllOrders.forEach(s -> System.out.println(s));
		
		
	}

	
	
}
