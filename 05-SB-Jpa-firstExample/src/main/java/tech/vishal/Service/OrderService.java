package tech.vishal.Service;



import tech.vishal.entity.OrderEntity;

public interface OrderService {

	
//	OrderEntity addOrder(OrderEntity order);
//	
//	OrderEntity updateOrder(Long orderId);
	
	OrderEntity saveOrUpdate(OrderEntity order);
	
	OrderEntity getOrder(Long OrderId);
	
	Iterable<OrderEntity> getAllOrders();  // Because we need the multiple we use here Iterable 
	
	void deleteOrder(Long orderId);
	
}
