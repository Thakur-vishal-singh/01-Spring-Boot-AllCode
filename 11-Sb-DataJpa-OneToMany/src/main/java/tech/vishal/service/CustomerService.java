package tech.vishal.service;

import java.util.List;

import tech.vishal.entity.Customer;
import tech.vishal.entity.Order;

public interface CustomerService {

	
	Customer addOrders(Customer customer, List<Order> orders);

	Customer saveCustomer(Customer customer);
	
	void deleteCustomerById(Long  id);
	
	Customer fetchCustomerId(Long id);
	
}
