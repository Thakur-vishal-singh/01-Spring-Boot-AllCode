package tech.vishal.service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import tech.vishal.entity.OrderEntity;
import tech.vishal.entity.OrderStatus;

public interface OrderService {


	
	
	List<OrderEntity> saveAllOrderDate(List<OrderEntity> order);
	
	List<OrderEntity> getByCustomerIdOrOrderDate(Long customerId,LocalDate orderDate);
	
	List<Object[]> getAllCustomerOrderCount();
	
	List<OrderEntity> getOrderStatus(OrderStatus status);
	
	
}
