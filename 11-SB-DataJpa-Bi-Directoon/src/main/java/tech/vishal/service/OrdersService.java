package tech.vishal.service;

import java.util.List;
import java.util.Optional;

import tech.vishal.entity.Customer;
import tech.vishal.entity.Orders;

public interface OrdersService {

	Customer addOrders(Customer customer, List<Orders> order);
	
	Orders addCustomer(Customer customer, Orders order);
	
	Customer saveCustomer(Customer customer);
	
	// because of the fetch we can access the the Customer also selected here  
	Optional<Orders> loadOrder(Long id);
	
	
	
}
