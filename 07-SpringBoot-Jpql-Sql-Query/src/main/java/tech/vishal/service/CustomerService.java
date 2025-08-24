package tech.vishal.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import tech.vishal.entity.CustomerEntity;


public interface CustomerService {

	Iterable<CustomerEntity> insertCustomer(List<CustomerEntity> customer);
	
	CustomerEntity login(String email,String password);
	
	Optional<CustomerEntity> findByNumber(String number);
	
	List<CustomerEntity> findByIdOrDate(Integer Id, LocalDate date);
	
	
}

/*
package tech.vishal.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import tech.vishal.entity.CustomerEntity;


public interface CustomerService {

	Iterable<CustomerEntity> insertCustomer(List<CustomerEntity> customer);
	
	CustomerEntity login(String email,String password);
	
	Optional<CustomerEntity> findByNumber(String number);
	
	List<CustomerEntity> findByIdOrDate(Integer Id, LocalDate date);
	
	List<CustomerEntity> customerIsName(String customerName);

    public void findByCustomerId(Integer id);
}
*/