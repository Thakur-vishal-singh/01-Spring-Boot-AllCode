package tech.vishal.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="orders1")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Orders {
	
	@Id
	private Long orderId;
	
	private LocalDate datePurchased;
	
	@Enumerated( EnumType.STRING)
	private OrderStatus status;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="customer_id")
	private Customer customer;

}