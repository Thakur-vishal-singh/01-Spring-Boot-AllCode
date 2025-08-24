package tech.vishal.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tech.vishal.entity.OrderEntity;

public interface OrderRepo extends JpaRepository<OrderEntity, Long> {

	
	@Query(value ="Select * from orders2 where customer_id = ?", nativeQuery=true)
	List<OrderEntity> getAllCustomerWhereCustomerId(Long id);
	
	
	List<OrderEntity> findByCustomerIdBetween(Long first, long second);
	
	List<OrderEntity> findByCustomerId(Long id);
	
}
