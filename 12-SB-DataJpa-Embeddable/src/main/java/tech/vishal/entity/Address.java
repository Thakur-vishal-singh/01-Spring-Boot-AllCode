package tech.vishal.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable           // embaddable means it's a class which can be used in another entity class inside 
public class Address {

	private String houseNo;
	
	private String street;
	
	private String city;
	
	private Integer pincode;
	
}
