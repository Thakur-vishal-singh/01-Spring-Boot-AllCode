package tech.vishal.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="orders2")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

	@Id
	private Long orderId;
	
	private Long customerId;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	private LocalDate datePurchased;
	
}
