package tech.vishal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.vishal.entity.CustomerEntity;
import tech.vishal.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo repo;
	
	@Override
	public CustomerEntity findEmail(String email) {
		return repo.getEmail(email);
	}

	@Override
	public Optional<CustomerEntity> findNumber(Long number) {
		return repo.findByNumber(number);
	}

	@Override
	public CustomerEntity findName(String name) {
		return repo.getName(name);
	}

	@Override
	public List<CustomerEntity> findByAll() {
		return repo.findAll();
	}

	@Override
	public List<CustomerEntity> findNamelike(String name) {
		return repo.findByNameContaining(name);
	}

	@Override
	public Iterable<CustomerEntity> saveAll(List<CustomerEntity> customer) {
		return repo.saveAll(customer);
	}

	
	
}
