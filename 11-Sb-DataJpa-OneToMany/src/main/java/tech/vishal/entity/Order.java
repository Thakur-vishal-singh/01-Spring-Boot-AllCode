package tech.vishal.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="orders")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
	
	// here this order don't know the relationship about the customer 

	@Id
	private Long orderId;
	
	private LocalDate datePurchased;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name="status")
	private OrderStatus orderStatus;
	
}
