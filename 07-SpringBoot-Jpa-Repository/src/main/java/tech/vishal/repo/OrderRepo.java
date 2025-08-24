package tech.vishal.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.vishal.entity.OrderEntity;

public interface OrderRepo extends JpaRepository<OrderEntity, Long>{

	List<OrderEntity> findByCustomerId(Long orderId);
	
	List<OrderEntity> findByDatePurchasedGreaterThan(LocalDate date);
	
}
