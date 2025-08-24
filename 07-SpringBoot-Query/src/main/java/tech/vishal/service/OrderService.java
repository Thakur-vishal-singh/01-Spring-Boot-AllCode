package tech.vishal.service;

import java.util.List;

import tech.vishal.entity.OrderEntity;

public interface OrderService {

	List<OrderEntity> getAllCustomerBetween(Long first, Long second);
	
	List<OrderEntity> getAllCustomerId(Long id);
	
	List<OrderEntity> getCustomerId(Long id);
	
	
}
