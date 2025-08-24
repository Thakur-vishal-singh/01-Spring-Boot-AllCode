package tech.vishal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tech.vishal.Repo.OrderRepo;
import tech.vishal.entity.OrderEntity;

@Service
public class OrderServiceImpl implements OrderService {

	OrderRepo orderRepo;
	
	OrderServiceImpl(OrderRepo orderRepo){
		this.orderRepo=orderRepo;
	}
	
	
	@Override
	public List<OrderEntity> getAllCustomerBetween(Long first, Long second) {
		List<OrderEntity>  getting = orderRepo.findByCustomerIdBetween(first, second);
		return getting;
	}
	
	
	@Override
	public List<OrderEntity> getAllCustomerId(Long id) {
		List<OrderEntity> getting = orderRepo.getAllCustomerWhereCustomerId(id);
		return getting;
	}
	
	
	@Override
	public List<OrderEntity> getCustomerId(Long id) {
		List<OrderEntity> getting = orderRepo.findByCustomerId(id);
		return getting;
	}
	
	
	
	
	
}
