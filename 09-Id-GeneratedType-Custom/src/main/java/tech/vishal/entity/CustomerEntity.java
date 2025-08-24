package tech.vishal.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedQueries({
	
			@NamedQuery(
					
					name="CustomerEntity.getName",
					query="select c from CustomerEntity c where c.name = : userName"
						
						),
			
			@NamedQuery(
				
				name="CustomerEntity.getEmail",
				query ="select c from CustomerEntity c where c.email = :email"
			
					)
	
	
})


@Entity
@Table(name="customer_tb2")
@NoArgsConstructor
@Data
public class CustomerEntity {

	@Id
	@GenericGenerator(name = "custom-generator", strategy = "tech.vishal.genertor.CustomGenerator")
	@GeneratedValue(generator = "custom-generator")
	private Integer customerId;
	
	private String name;
	
	@Column(name="ph_number")
	private Long number;
	
	private String email;
	
}
