package tech.vishal.Entity;


import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class EmpEntity {

	
	Integer Id;
	
	String name;
	
	String email;
	
}
