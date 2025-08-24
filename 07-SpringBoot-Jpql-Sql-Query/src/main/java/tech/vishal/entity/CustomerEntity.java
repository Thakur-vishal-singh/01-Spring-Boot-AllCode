package tech.vishal.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="customer")
@NoArgsConstructor
@Data
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
	private String name;
	
	private String phoneNo;
	
	private String emailId;
	
	private String password;
	
	
	@CreationTimestamp
	private LocalDate createDate;
	
	@UpdateTimestamp
	private LocalDate updateDate;

	public CustomerEntity(String name, String phoneNo, String emailId, String password) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.password = password;
	}

	
	
	
	
}
