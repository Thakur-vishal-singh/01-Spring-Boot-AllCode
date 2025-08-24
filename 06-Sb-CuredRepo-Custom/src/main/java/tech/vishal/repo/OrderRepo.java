package tech.vishal.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tech.vishal.entity.OrderEntity;
import tech.vishal.entity.OrderStatus;

public interface OrderRepo extends CrudRepository<OrderEntity, Long> {


	public List<OrderEntity> findByCustomerId(Long customerId);

	public List<OrderEntity> findByOrderStatus(OrderStatus orderStatus);

	public List<OrderEntity> findByDatePurchased(LocalDate deliverDate);

//	dataPurchased
}
