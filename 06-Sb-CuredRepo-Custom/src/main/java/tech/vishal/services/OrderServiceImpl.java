package tech.vishal.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.vishal.entity.OrderEntity;
import tech.vishal.entity.OrderStatus;
import tech.vishal.repo.OrderRepo;


@Service
public class OrderServiceImpl implements OrderServices {


	OrderRepo orderRepo;

	@Autowired
	OrderServiceImpl(OrderRepo orderRepo){
	this.orderRepo = orderRepo;
	}

	@Override
	public OrderEntity orderSave(OrderEntity orderSave) {
		return orderRepo.save(orderSave);
	}



	@Override
	public Optional<OrderEntity> OrderFind(Long orderFind) {

		Optional<OrderEntity> example = orderRepo.findById(orderFind);
		if(example.isEmpty()) {
			return null;
		}
		return example;
	}



	@Override
	public List<OrderEntity> getOrderStatus(OrderStatus orderStatus) {
		return orderRepo.findByOrderStatus(orderStatus);
	}

	@Override
	public List<OrderEntity> getCustomerId(Long customerId) {
		return orderRepo.findByCustomerId(customerId);
	}

	@Override
	public List<OrderEntity> getOrderPurchasedDate(LocalDate orderDate) {
		return orderRepo.findByDatePurchased(orderDate);
	}

}
