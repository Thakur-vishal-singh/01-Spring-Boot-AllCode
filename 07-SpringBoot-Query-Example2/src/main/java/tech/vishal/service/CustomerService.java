package tech.vishal.service;

import java.util.List;

import tech.vishal.entity.CustomerEntity;

public interface CustomerService {

	Iterable<CustomerEntity> saveAllCustomerData(List<CustomerEntity> insert);
	
	String CustomerLogin(String name, String password);
	
	
	CustomerEntity customerIsName(String customerName);
	
	
	void findByCustomerId(Integer name);
	
	public Iterable<CustomerEntity> getAllTheRecordes();

	
}
