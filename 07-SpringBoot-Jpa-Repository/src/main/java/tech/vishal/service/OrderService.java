package tech.vishal.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import tech.vishal.entity.OrderEntity;

public interface OrderService {
	
	
//	List<OrderEntity> getAllCustomerAll();
	
	List<OrderEntity> getCustomerId(Long customerId);
	
	List<OrderEntity> getOrderGreaterThen(LocalDate date);
	
    Optional<OrderEntity> getSpecificId(Long id);
	
	List<OrderEntity> gettingAll();
}
