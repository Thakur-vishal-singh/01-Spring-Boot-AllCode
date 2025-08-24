package tech.vishal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;
import tech.vishal.entity.OrderEntity;
import tech.vishal.entity.OrderStatus;

public interface OrderRepo extends JpaRepository<OrderEntity,Long>{

	@Query(name = "OrderEntity.getAll")
	List<OrderEntity> getAll();
	
	@Query(name = "OrderEntity.customerCountMoreThenOne")
	List<Object[]> customerCountMoreThenOne();
	
	@Modifying
	@Transactional
	@Query(value ="delete from orders2 where status= ?1", nativeQuery = true)
	int deleteQuery(String status);
	
//	@Modifying
//	@Query(value = "DELETE FROM orders2 WHERE status = ?1", nativeQuery = true)
//	int deleteByStatus(OrderStatus status);

    List<OrderEntity> findByStatus(OrderStatus status);
	
}
