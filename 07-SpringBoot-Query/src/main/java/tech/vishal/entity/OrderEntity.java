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


@Table(name ="orders2")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

	@Id
	private Long orderId;
	
	private Long customerId;
	
	private LocalDate datePurchased;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus Status;
	
	
	
}
