package tech.vishal.runner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import tech.vishal.entity.OrderEntity;
import tech.vishal.entity.OrderStatus;
import tech.vishal.repo.OrderRepo;

@Order(1)
@Component
public class MyAppRunner2 implements CommandLineRunner{

	@Autowired
	OrderRepo orderRepo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List<OrderEntity> listOrders = new ArrayList<>();
		
		listOrders.add(new OrderEntity(19002L,102L,LocalDate.of(2025, 03, 21),OrderStatus.DELIVERED));
		listOrders.add(new OrderEntity(19003L,103L,LocalDate.of(2025, 03, 24),OrderStatus.CANCELED));
		listOrders.add(new OrderEntity(19004L,104L,LocalDate.of(2025, 03, 25),OrderStatus.DELIVERED));
		listOrders.add(new OrderEntity(19005L,105L,LocalDate.of(2025, 03, 18),OrderStatus.PROCESSED));
		listOrders.add(new OrderEntity(19006L,106L,LocalDate.of(2025, 03, 23),OrderStatus.DELIVERED));
		listOrders.add(new OrderEntity(19007L,107L,LocalDate.of(2025, 03, 19),OrderStatus.REFUNDED));

		orderRepo.saveAll(listOrders);
	
	}

}
