package tech.vishal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.vishal.entity.Customer;
import tech.vishal.entity.Orders;
import tech.vishal.repository.CustomerRepository;
import tech.vishal.repository.OrdersRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrdersRepository orderRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Override
	public Customer addOrders(Customer customer, List<Orders> order) {
		customer.setOrders(order);
		return customerRepo.save(customer) ;
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
	public List<Orders> printorders() {
		List<Orders> all = orderRepo.findAll();
		return all;
	}
	
	
}
