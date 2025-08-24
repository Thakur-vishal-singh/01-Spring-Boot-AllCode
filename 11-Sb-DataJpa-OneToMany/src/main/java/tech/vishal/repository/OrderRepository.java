package tech.vishal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.vishal.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
 
}
