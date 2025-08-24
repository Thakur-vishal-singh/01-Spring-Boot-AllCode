package tech.vishal.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import tech.vishal.entity.Customer;
import tech.vishal.entity.OrderStatus;
import tech.vishal.entity.Orders;
import tech.vishal.service.OrdersServices;


@Component
public class MyApplicationRunner implements ApplicationRunner {

	@Autowired
	OrdersServices ordersService;

	
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		
//		insertCustomer();
//		
//	}
//
//	private void insertCustomer() {
//		
//Customer customer  = new Customer();
//		
//		customer.setName("jhon");
//		customer.setNumber("123456789");
//		
//		List<Orders> orders = Arrays.asList(
//				// in the order we don't have the auto generated so we have to give here all
//				new Orders(190076,LocalDate.of(2025, 04, 06),OrderStatus.ORDERED,null),
//				new Orders(148870, LocalDate.of(2024, 04, 07),OrderStatus.PROCESSED,null),
//				new Orders(133465, LocalDate.of(2025, 04, 02),OrderStatus.DELIVERED,null),
//				new Orders(120021, LocalDate.of(2025, 04, 05),OrderStatus.CANCELED,null),
//				new Orders(150021, LocalDate.of(2025, 04, 06),OrderStatus.REFUNDED,null)			
//				);
//		
//		Customer customer2 = customerRepo.addCustomer(orders, customer);
//				
//		customerRepo.saveCustomer(customer2);
//		
//		
//	}
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		saveCustomer();
		
		fetchOrder(1002);

	}

	public void fetchOrder(Integer id) {
		Optional<Orders> optinalOrder = ordersService.loadOrder(id);
		
		optinalOrder.ifPresentOrElse(
				orders ->{
					System.out.println("Order Id ::::"+orders.getId());
					System.out.println("Date Purchased  ::::"+orders.getDataPurchased());
					System.out.println("Order Status  ::::"+orders.getStatus());
					System.out.println("Order Customer Id  :::"+orders.getCustomer().getCustomerid());
					System.out.println("order Name  ::::"+orders.getCustomer().getName());
					System.out.println("order Number  ::::"+orders.getCustomer().getNumber());
				},
				() ->{
					System.out.println("Order found Id "+id+"not found");
				}
		);
		
		
	}

	public void saveCustomer() {
		
		Customer customer  = new Customer();
		
		customer.setName("jhon");
		customer.setNumber("123456789");
		
		List<Orders> orders = Arrays.asList(
				// in the order we don't have the auto generated so we have to give here all
				new Orders(190076,LocalDate.of(2025, 04, 06),OrderStatus.ORDERED,null),
				new Orders(148870, LocalDate.of(2024, 04, 07),OrderStatus.PROCESSED,null),
				new Orders(133465, LocalDate.of(2025, 04, 02),OrderStatus.DELIVERED,null),
				new Orders(120021, LocalDate.of(2025, 04, 05),OrderStatus.CANCELED,null),
				new Orders(150021, LocalDate.of(2025, 04, 06),OrderStatus.REFUNDED,null)			
				
				);
		
		Customer check = ordersService.addOrders(customer, orders);
		if(Objects.nonNull(check)) {
			System.out.println("The Customer Is inserted with his orders to the Database");
		System.out.println("The Customer Is inserted with his orders to the Database");
		System.out.println("The customer id is :"+customer.getCustomerid());
		System.out.println("====".repeat(30));
		}else {
			System.out.println("Not inserted ");
		}
		
		
		Customer customer2 = new Customer();
		customer2.setName("vickey");
		customer2.setNumber("987654321");
		
		Orders order1 = new Orders(1907,LocalDate.of(2025, 05, 06),OrderStatus.ORDERED,null);
		Orders order2 = new Orders(1487, LocalDate.of(2024, 05, 02),OrderStatus.PROCESSED,null);
		Orders order3 = new Orders(1346, LocalDate.of(2025, 05, 07),OrderStatus.DELIVERED,null);
		Orders order4 = new Orders(1002, LocalDate.of(2025, 05, 03),OrderStatus.CANCELED,null);
		Orders order5 = new Orders(1012, LocalDate.of(2025, 05, 07),OrderStatus.REFUNDED,null);				
		
		
		order1 = ordersService.addCustomer(customer2, order1);
		order2 = ordersService.addCustomer(customer2, order2);
		order3 = ordersService.addCustomer(customer2, order3);
		order4 = ordersService.addCustomer(customer2, order4);
		order5 = ordersService.addCustomer(customer2, order5);

		
		List<Orders> insertOrders = Arrays.asList(order1,order2,order3,order4,order5 );
		
		Customer check2 = ordersService.addOrders(customer2, insertOrders);
		
		
		Customer saveCustomer = ordersService.saveCustomer(customer2);
		
		
		if(Objects.nonNull(saveCustomer)) {
			System.out.println("The Customer Is inserted with his orders to the Database");
		System.out.println("customer id generated is "+customer2.getCustomerid());
		}else {
			System.out.println("not inserted ");
		}
		
	}

}
