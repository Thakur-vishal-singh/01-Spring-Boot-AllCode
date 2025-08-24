package tech.vishal.Servcie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.vishal.model.Orders;
import tech.vishal.repo.ApplicationRepo;

@Service
public class ApplicationServices {

	@Autowired
	ApplicationRepo repo;

//	public void printAll() {
//		
//	System.out.println("finding the 2");
//		
//	repo.findById(2);
//	
//	
//	System.out.println("saving the data ");
//	Order order = new Order(4,"laptop",2);
//	    
//	repo.save(order);
//	
//	System.out.println("delete the id ");
//	repo.deleteById(2);	 
//	
//	System.out.println("findind the all");
//	repo.findByAll();
//	
//	
//	System.out.println("");
//	
//	 
//	 
//	}
	
	
	public void saveOrder(Orders o) {
		repo.save(o);
		System.out.println("all the data save success");
	}
	
	public void updateOrder(int orderId, int quentity) {
		repo.updateQuentity(orderId, quentity);
		System.out.println("update Success");
	}
	
	public int deleteOrder(int id) {
		int a = repo.deleteById(id);
		System.out.println("order is deleted success");
		return a;
	}
	
	public void findById(int id) {
		repo.findById(id);
	}
	
	public void findByAll() {
		repo.findByAll();
	}
	
	
	
	
}
