package tech.vishal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Table(name = "bank_account")
@Entity
@Data
public class BankAccount {

	@Id
	private String accountNumber;
	
	private String accountHolderName;
	
	
}
