package tech.vishal.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import tech.vishal.entity.OrderEntity;
import tech.vishal.entity.OrderStatus;

public interface OrderServices {

	OrderEntity orderSave(OrderEntity orderSave);

	Optional<OrderEntity> OrderFind(Long orderFind);

	List<OrderEntity> getOrderStatus(OrderStatus orderStatus);

	List<OrderEntity> getCustomerId(Long customerId);

	List<OrderEntity> getOrderPurchasedDate(LocalDate orderDate);




}
