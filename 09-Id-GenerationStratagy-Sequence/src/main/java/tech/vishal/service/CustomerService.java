package tech.vishal.service;

import java.util.List;

import tech.vishal.entity.CustomerEntity;

public interface CustomerService {

	
	CustomerEntity login(String email, String name);
	
	List<CustomerEntity> getNumberData(Long number);
	
}
