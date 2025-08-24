package tech.vishal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.vishal.entity.Customer;
import tech.vishal.entity.Order;
import tech.vishal.repository.CustomerRepository;

@Service( value = "customerService") // first letter should be lower and same name of the class name
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository repo;
	
	@Override
	public Customer addOrders(Customer customer, List<Order> orders) {
		customer.setOrders(orders);
		return customer;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		customer = repo.save(customer);
		return customer;
	}

	@Override
	public void deleteCustomerById(Long id) {
	repo.deleteById(id);
	}

	@Override
	public Customer fetchCustomerId(Long id) {
		Customer customer = repo.findById(id).get();// the findbyId return type id optional and it have get method so we can use this method to get value 
		return customer;
	}

	
	
}
