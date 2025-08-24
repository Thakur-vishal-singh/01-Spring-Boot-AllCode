package tech.vishal.entity;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NamedQueries({
		@NamedQuery(
				name="OrderEntity.getAll",
				query="select e from OrderEntity e"
				),
		
		@NamedQuery(
				name="OrderEntity.customerCountMoreThenOne",
				query="select e.customerId , count(e) from OrderEntity e group by e.customerId having count(e) > 1"				
				)
		
})
// it make easy to look what name we give if we use the NameQuery because we use this inside the Entity class not the Repository 

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orders2")
@Data
public class OrderEntity {

	@Id
	private Long orderId;
	
	private Long customerId;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	private LocalDate datePurchased;
	
	
}
