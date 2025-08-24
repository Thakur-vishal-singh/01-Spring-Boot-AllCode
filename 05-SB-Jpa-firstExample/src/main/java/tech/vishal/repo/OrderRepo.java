package tech.vishal.repo;



import org.springframework.data.repository.CrudRepository;

import tech.vishal.entity.OrderEntity;

public interface OrderRepo extends CrudRepository<OrderEntity, Long> {
	
}
