package tech.vishal.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.vishal.entity.CustomerEntity;
import tech.vishal.repo.CustomerRepo;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired CustomerRepo repo;
	
	@Override
	public CustomerEntity login(String email, String name) {
		return repo.login(email, name);
	}

	@Override
	public List<CustomerEntity> getNumberData(Long number) {
		return repo.getByNumber(number);
	}

}
