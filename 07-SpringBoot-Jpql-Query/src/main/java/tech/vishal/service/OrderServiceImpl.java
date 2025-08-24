package tech.vishal.service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.vishal.entity.OrderEntity;
import tech.vishal.entity.OrderStatus;
import tech.vishal.repo.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepo repo;
	
	
	@Override
	public List<OrderEntity> saveAllOrderDate(List<OrderEntity> order) {
		return repo.saveAll(order);
	}

	@Override
	public List<OrderEntity> getByCustomerIdOrOrderDate(Long customerId, LocalDate orderDate) {
		return repo.findByCustomerIdOrOrderDate(customerId, orderDate);
	}

	@Override
	public List<Object[]> getAllCustomerOrderCount() {
		return repo.fetchOrdersCountByCustomerId();
	}

	@Override
	public List<OrderEntity> getOrderStatus(OrderStatus status) {
		return repo.getOrderWithStatus(status);
	}

}
