package tech.vishal.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tech.vishal.entity.OrderEntity;
import tech.vishal.entity.OrderStatus;

public interface OrderRepo extends JpaRepository<OrderEntity, Long> {

	@Query("select o from OrderEntity o where o.status = ?1")
	List<OrderEntity> getOrderWithStatus(OrderStatus status);
	
	@Query("select o from OrderEntity o where o.customerId = :customerId and o.datePurchased = :datePurchased")
	List<OrderEntity> findByCustomerIdOrOrderDate(@Param("customerId") Long CustomerId, @Param("datePurchased") LocalDate date);
	
	@Query("select o.customerId, count(o) from OrderEntity o group by o.customerId")
	List<Object[]> fetchOrdersCountByCustomerId();
//						|| jpa don't support the map directly so we have to use here object array
//	Map<Integer, Integer> fetchOrdersCountByCustomerId();
	
}
