package tech.vishal.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.vishal.entity.OrderEntity;
import tech.vishal.repo.OrderRepo;

@Service("orderService") // here we define our own name for this class 
public class OrderServiceImpl implements OrderService {

	@Autowired OrderRepo orderRepo;

	@Override
	public OrderEntity getOrder(Long OrderId) {
		 Optional<OrderEntity> opt = orderRepo.findById(OrderId);
		 if(opt.isPresent()) {
			 return opt.get();
		 }
		return null;
	}

	@Override
	public  Iterable<OrderEntity> getAllOrders() {
	  return orderRepo.findAll();
	}// if use the list   (List<Order>) empRepo.findAll();

	
	
	@Override
	public OrderEntity saveOrUpdate(OrderEntity order) {
		return orderRepo.save(order);// this save method inherit from the CuredRespository 
	}// after saving it will return the instance after saving because we have the id when it save here we don't save 

	
	
	
	
	@Override
	public void deleteOrder(Long orderId) {
		orderRepo.deleteById(orderId);
	}

	// jpa is specification and hibernate is a implementation of jpa specification 
	// here controller call the server and service call the Repository and Repository call the entity 
	// the user calls the controller how ? with fronted application which is react or angular js 
	
	// this all called full stack application 
}

