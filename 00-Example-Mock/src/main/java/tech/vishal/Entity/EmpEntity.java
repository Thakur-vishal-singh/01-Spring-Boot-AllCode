package tech.vishal.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="emp_tb1")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmpEntity {

	@Id
	private Integer empId;
	private String name;
	
	
}
