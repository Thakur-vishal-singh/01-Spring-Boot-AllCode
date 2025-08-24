package tech.vishal.service;

import java.util.List;

import tech.vishal.entity.CustomerEntity;

public interface CustomerService {


	CustomerEntity getAllByEmail(String email);
	
//	List<Object[]> getAllDate();
	List<CustomerEntity> getAllDate();
	
}
