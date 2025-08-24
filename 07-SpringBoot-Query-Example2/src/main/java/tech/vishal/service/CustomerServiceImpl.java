package tech.vishal.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.vishal.entity.CustomerEntity;
import tech.vishal.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{

	
	@Autowired
	CustomerRepo repo;
	
	
	@Override
	public Iterable<CustomerEntity> saveAllCustomerData(List<CustomerEntity> customer) {
		return repo.saveAll(customer);
	}
	
	@Override
	public CustomerEntity customerIsName(String customerName) {
		Optional<CustomerEntity>  name = repo.findByName(customerName);
		if(name.isPresent()) {
			return name.get();
		}
			return null;
	}
	
	@Override
	public String CustomerLogin(String name, String password) {
		CustomerEntity login = repo.findByNameAndPassword(name, password);
		if(Objects.nonNull(login)) {
			return "user login success ::::"+login;
		}
		return "userLogin is falied   ::::"+null;
	}

	@Override
	public void findByCustomerId(Integer name) {
		Optional<CustomerEntity> byId = repo.findById(name);
		if(byId.isPresent()) {
			System.out.println(byId.get());
		}else {
			System.out.println("no data found");
		}
	}
	

	public Iterable<CustomerEntity> getAllTheRecordes() {	
			return repo.findAll();
	}
	 
	
}
