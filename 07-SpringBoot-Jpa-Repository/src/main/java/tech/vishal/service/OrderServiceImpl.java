package tech.vishal.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.vishal.entity.OrderEntity;
import tech.vishal.repo.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepo orderRepo;
	
	
//	@Override
//	public List<OrderEntity> getAllCustomer() {
//		return orderRepo.findByAllCustomerId();
//	}
	
	@Override
	public List<OrderEntity> getCustomerId(Long customerId) {
		return orderRepo.findByCustomerId(customerId);
	}
	
	 @Override
	public List<OrderEntity> getOrderGreaterThen(LocalDate date) {
		return orderRepo.findByDatePurchasedGreaterThan(date);
	}
	 
	 @Override
	public Optional<OrderEntity> getSpecificId(Long id) {
		Optional<OrderEntity> byId = orderRepo.findById(id);
		return byId;
	}
	 
	@Override
	public List<OrderEntity> gettingAll() {
		return orderRepo.findAll();
	}
	 
	
}
