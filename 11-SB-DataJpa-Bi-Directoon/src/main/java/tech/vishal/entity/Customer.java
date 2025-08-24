package tech.vishal.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="customers")
public class Customer {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Long number;
	
	// mapped by is used to show it is the bi-direction relationship and
	// mapped by tell where the relationship own means where is the foreign key 
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "customer")
	List<Orders> orders;
	
	
}
