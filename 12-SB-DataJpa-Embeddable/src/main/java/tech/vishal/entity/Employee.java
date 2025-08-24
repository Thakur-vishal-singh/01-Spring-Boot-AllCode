package tech.vishal.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "EMPLOYEE_INFO")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {

	@Id
	private Integer id;
	
	private String ename;
	
	private Double sal;
	
	@Embedded
	private Address address;
	
	
}
