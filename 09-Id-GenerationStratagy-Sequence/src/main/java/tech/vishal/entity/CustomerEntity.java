package tech.vishal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;


@NamedQueries({
		
		@NamedQuery(
				
				name="CustomerEntity.login",
//				query="select c from CustomerEntity c where (c.email=:mail or e.number=:phno) And c.password=:pwd "
				query="select c from CustomerEntity c where c.email=:mail And c.name=:name"
				),
		@NamedQuery(
				
				name="CustomerEntity.getByNumber",
				query="select c from CustomerEntity c where c.number = :phno"
				)
	
})
@Entity
@Table(name="customer_tb1")
@NoArgsConstructor
@Data
public class CustomerEntity {

	@Id
	@Column(name="customer_id")
	@SequenceGenerator(name="customer_seq_gen", sequenceName="customer_tb1_seq", allocationSize =  1)
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "customer_seq_gen")
//	@TableGenerator(name = "gen", table="id_generator", pkColumnName="id_gen", valueColumnName="val_gen", pkColumnValue="cust_id" , allocationSize=1)
//	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gen")
	private Integer customerId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="ph_number")
	private Long number;
	
	@Column(name="email")
	private String email;

	
	
}
//Segoe UI