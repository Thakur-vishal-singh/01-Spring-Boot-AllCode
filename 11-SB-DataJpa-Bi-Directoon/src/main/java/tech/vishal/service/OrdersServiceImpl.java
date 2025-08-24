package tech.vishal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import tech.vishal.entity.Customer;
import tech.vishal.entity.Orders;
import tech.vishal.repository.CustomerRepository;
import tech.vishal.repository.OrdersRepository;


@Service(value ="customerService")
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	OrdersRepository orderRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Override
	public Customer addOrders(Customer customer, List<Orders> orders) {
		customer.setOrders(orders);
//		for(Orders order : orders) {
//			order.setCustomer(customer);
//		} in java 8 we can do this
		orders.stream().forEach(order -> order.setCustomer(customer));	
		return customerRepo.save(customer);
	}

	@Override
	public Orders addCustomer(Customer customer, Orders order) {
		order.setCustomer(customer);
		return order;
	}
	
	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public Optional<Orders> loadOrder(Long id) {
		return Optional.ofNullable(orderRepo.findById(id).orElse(null));
	}

}
