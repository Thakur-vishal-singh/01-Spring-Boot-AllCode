package tech.vishal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tech.vishal.entity.OrderEntity;
import tech.vishal.entity.OrderStatus;
import tech.vishal.repo.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepo repo;
	
	
	@Override
	public List<OrderEntity> getAllOrder() {
		return repo.getAll();
	}

	@Override
	public List<Object[]> getAllCustomerMoreThenOne() {
		return repo.customerCountMoreThenOne();
	}

	@Override
	public List<OrderEntity> deleteQueryStatus(OrderStatus status) {
		
		List<OrderEntity> toBeDeleted = repo.findByStatus(status);
//		toBeDeleted.forEach(s -> System.out.println(s));
		
		 int getDelete = repo.deleteQuery(status.getValue());
		System.out.println("cancel order delete ::::"+getDelete);
		return toBeDeleted;
	}
	

//	 	@Override
//	    @Transactional
//	    public List<OrderEntity> deleteQueryStatus(OrderStatus status) {
//
//	        // Find the orders to be deleted
//	        List<OrderEntity> toBeDeleted = repo.findByStatus(status);
//	        
//	        // Log the orders that will be deleted
//	        System.out.println("Orders to be deleted:");
//	        toBeDeleted.forEach(System.out::println);
//
//	        // Perform the delete operation
//	        int deletedCount = repo.deleteByStatus(status);
//	        System.out.println("Deleted " + deletedCount + " rows.");
//	        
//	        // Return the list of deleted orders
//	        return toBeDeleted;
//	    }
}
