package tech.vishal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.vishal.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
 
}
