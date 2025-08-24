package tech.vishal.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
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
	public Iterable<CustomerEntity> insertCustomer(List<CustomerEntity> customer) {
 	 return repo.saveAll(customer);
	}
	
	
	 @Override
	public List<CustomerEntity> findByIdOrDate(Integer id, LocalDate date) {
		return repo.findByCustomerIdOrCreateDate(id, date);
	}
	
	
	
	
	 @Override
	public CustomerEntity login(String email, String password) {
		CustomerEntity example = repo.findByEmailIdAndPassword(email, password);
		if(Objects.isNull(example))
			return null;
		else {
			System.out.println("you login is success check your all info :::: ");
			return example;
	}
	}
	 
	@Override
	public Optional<CustomerEntity> findByNumber(String number) {
		Optional<CustomerEntity> checkNumber = repo.findByPhoneNo(number);
		if(checkNumber.isPresent()) {
			System.out.println("this is your number data have :::: ");
		return checkNumber;
		}else {
			return null;
		}
	}
	
	
	
	
	
	
}



//package tech.vishal.service;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import tech.vishal.entity.CustomerEntity;
//import tech.vishal.repo.CustomerRepo;
//
//@Service
//public class CustomerServiceImpl implements CustomerService {
//
//    @Autowired
//    private CustomerRepo repo;
//
//    @Override
//    public Iterable<CustomerEntity> insertCustomer(List<CustomerEntity> customers) {
//        return repo.saveAll(customers);
//    }
//
//    @Override
//    public List<CustomerEntity> customerIsName(String customerName) {
//    	List<CustomerEntity> 
//    	customer = repo.findByName(customerName);
////        return Optional.ofNullable(customer.orElse(null)); // Return null if not found
//    	  if (Objects.nonNull(customer)) {
//              return  customer;
//          }
//          return null;
//    }
//
//    @Override
//    public CustomerEntity login(String name, String password) {
//        CustomerEntity login = repo.findByNameAndPassword(name, password);
//        if (Objects.nonNull(login)) {
//            return  login;
//        }
//        return null;
//    }
//
//    
//    
//    @Override
//    public void findByCustomerId(Integer id) {
//        Optional<CustomerEntity> customer = repo.findById(id);
//        if(customer.isPresent()) {
//            System.out.println(customer.get());
//        } else {
//            System.out.println("No data found for ID: " + id);
//        }
//    }
//    
//    
//    
//    @Override
//    public List<CustomerEntity> findByIdOrDate(Integer Id, LocalDate date) {
//    	// TODO Auto-generated method stub
//    	return null;
//    }
//    @Override
//    public Optional<CustomerEntity> findByNumber(String number) {
//    	// TODO Auto-generated method stub
//    	return Optional.empty();
//    }
//    
//    
//    
//}