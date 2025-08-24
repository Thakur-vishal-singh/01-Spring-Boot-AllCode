package tech.vishal.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import tech.vishal.entity.OrderEntity;
import tech.vishal.entity.OrderStatus;
import tech.vishal.services.OrderServices;

@Component
public class OrderRunner implements ApplicationRunner{


	OrderServices orderServices;

	@Autowired
	public void setOrderServices(OrderServices orderServices) {
		this.orderServices=orderServices;
	}


	@Override
	public void run(ApplicationArguments arg) {

		OrderEntity example = new OrderEntity(1l,1l,LocalDate.of(2025, 03, 21),OrderStatus.PROCESSED);

		orderServices.orderSave(example);

		System.out.println("your order on 2025 03 21 ::::");
		List<OrderEntity> data = orderServices.getOrderPurchasedDate(LocalDate.of(2025, 03, 21));
		data.forEach(s -> System.out.println(s));

		List<OrderEntity> orderStatus = orderServices.getOrderStatus(OrderStatus.PROCESSED);
		orderStatus.forEach(s -> System.out.println(s));

		List<OrderEntity> customerId = orderServices.getCustomerId(1l);
		customerId.forEach(s -> System.out.println(s));


	}


}
