package tech.vishal.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;

import tech.vishal.Servcie.ApplicationServices;
import tech.vishal.model.Orders;

@Component
@Order(value = 2)
public class ServicesOrderRunner implements org.springframework.boot.ApplicationRunner{

	
	
	@Autowired
	ApplicationServices ser;
	
	@Override
	public void run(ApplicationArguments arg) {
		System.out.println("Second runner componen is running");

		
	Orders order = new Orders(7,"pen",20);
	ser.saveOrder(order);
	
	System.out.println("=".repeat(30));
	
	System.out.println(ser.deleteOrder(2));
	
	System.out.println("=".repeat(30));
	
	ser.findByAll();

	System.out.println("=".repeat(30));
	
	// here update will show because this run after the all print 
	ser.updateOrder(6, 6);
	
	System.out.println("==".repeat(20));
		
	ser.findById(2);
	
	}	
	
}
