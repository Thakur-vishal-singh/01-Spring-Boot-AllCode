package tech.vishal.service;

import java.util.List;

import tech.vishal.entity.OrderEntity;
import tech.vishal.entity.OrderStatus;

public interface OrderService {

	List<OrderEntity> getAllOrder();
	
	List<Object[]> getAllCustomerMoreThenOne();
	
	List<OrderEntity> deleteQueryStatus(OrderStatus status);
	
}
