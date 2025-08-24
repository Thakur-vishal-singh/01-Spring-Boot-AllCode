package tech.vishal.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import tech.vishal.entity.OrderEntity;
import tech.vishal.entity.OrderStatus;
import tech.vishal.service.OrderService;

@Component
public class OrderRunner  implements ApplicationRunner{

	
	@Autowired
	OrderService service;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		
		List<OrderEntity> listOrder =service.getAllOrder();
		listOrder.forEach(s -> System.out.println(s));
		
		List<Object[]> get = service.getAllCustomerMoreThenOne();
		
		for(Object[] take : get) {
			System.out.println("customerId :::: "+take[0]+" Orders ::::"+take[1]);
		}
		
		
//		List<OrderEntity> ex = service.deleteQueryStatus(OrderStatus.CANCELED);
//		System.out.println("Deleted Orders");
//		ex.forEach(System.out::println);

        List<OrderEntity> deletedOrders = service.deleteQueryStatus(OrderStatus.CANCELED);
        System.out.println("Deleted Orders:");
        deletedOrders.forEach(System.out::println);
		
	}
	

	
	
	
}
