package tech.vishal.entity;

import org.hibernate.generator.Generator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
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
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gen1")
	@TableGenerator(name="gen1", table="id_customer_tb", pkColumnName="id_column", valueColumnName="val_column",  pkColumnValue="pk_value" )
	private Integer customerId;
	
	private String name;
	
	@Column(name="ph_number")
	private Long number;
	
	private String email;
	
}













//@GeneratedValue( strategy = GenerationType.TABLE, generator =  "gen" )
//@TableGenerator(name="gen", table="id_customer_tb", pkColumnName="pk_column", valueColumnName="val_column", pkColumnValue="pk_value", allocationSize = 1 )
