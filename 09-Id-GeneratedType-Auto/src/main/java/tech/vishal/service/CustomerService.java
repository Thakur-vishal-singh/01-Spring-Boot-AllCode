package tech.vishal.service;

import java.util.List;
import java.util.Optional;

import tech.vishal.entity.CustomerEntity;

public interface CustomerService {

	
	CustomerEntity findEmail(String email);
	Optional<CustomerEntity> findNumber(Long number );
	CustomerEntity findName(String name);
	List<CustomerEntity> findByAll();
	List<CustomerEntity> findNamelike(String name);
	Iterable<CustomerEntity> saveAll(List<CustomerEntity> customer);
	
	
}
