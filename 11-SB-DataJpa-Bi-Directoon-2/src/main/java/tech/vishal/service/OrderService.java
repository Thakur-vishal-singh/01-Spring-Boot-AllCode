package tech.vishal.service;

import java.util.List;

import tech.vishal.entity.Customer;
import tech.vishal.entity.Orders;

public interface OrderService {

	
	Customer addOrders(Customer customer,List<Orders> order);
	
	Orders addCustomer(Customer customer, Orders order);
	
	Customer saveCustomer(Customer customer);
	
	List<Orders> printorders();
	
	
}
