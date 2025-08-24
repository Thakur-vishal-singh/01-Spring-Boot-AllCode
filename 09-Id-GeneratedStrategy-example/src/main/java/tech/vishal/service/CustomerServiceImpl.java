package tech.vishal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.vishal.entity.CustomerEntity;
import tech.vishal.repo.CustomerRepo;


@Service
public class CustomerServiceImpl implements CustomerService{

	
	@Autowired CustomerRepo repo;
	
	
//	@Override
//	public List<CustomerEntity> saveAllCustomerData(List<CustomerEntity> customer) {
////		repo.saveAll(customer);
//		return repo.saveAll(customer);
//	}

	@Override
	public CustomerEntity getAllByEmail(String email) {
		return repo.getEmail(email);
	}

//	@Override
//	public List<Object[]> getAllDate() {
//		return repo.getAll();
//	}

	@Override
	public List<CustomerEntity> getAllDate() {
		return repo.getAll();
	}
	
	
	
	
}
