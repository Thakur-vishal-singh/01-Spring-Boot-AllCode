package tech.vishal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NamedNativeQueries({
	
		@NamedNativeQuery(
				
				name = "CustomerEntity.getEmail", 
				query = "select * from customer_tb1 where email = :data",
				resultClass = CustomerEntity.class
				
				),
		@NamedNativeQuery(
				name = "CustomerEntity.fetchAllWithoutResultset", 
				query = "select * from customer_tb1",
				resultClass = CustomerEntity.class
				)
//		@NamedNativeQuery(
//				name = "CustomerEntity.fetchAllWithoutResultset", 
//				query = "select * from customer_tb1"
//				)
		
	
})

@Entity
@Table(name="customer_tb1")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq_gen")
	@SequenceGenerator(name = "customer_seq_gen", sequenceName = "customer_tb1_seq", allocationSize = 1)
	Integer customerId;// the name in the @SequenceGenerator that is the connection which is tell to the @GeneratedValue generator to connect 
	// low below the code total four example with example of @GeneratedValue and @GenerationType 
	
	String name;
	
	String email;
	
	Long phNumber;
	
}
/*
 
 **note auto and IDENTITY is the easy example to use it 
 
 IDENTITY
 this is for the database who support the auto_increment for example the mysql support auto_increment example let see::::
 Ex : : : : @GeneratedValue( strategy = GenerationType.IDENTITY )

   SEQUENCE 
  this is for the database which support the Sequence to automatically generated the value for example Oracle-SQL and Postgre-SQL
 Ex : : : :   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen1")    // here the generator is for the linking with the @SequenceGenerator
 @SequenceGenerator( name="gen1" sequenceName="customer_tb1_seq", allocationSize = 1)  // here we give the name to linked between this two  @GeneratedValue @SequenceGenerator  
 
 
  AUTO
  this is when you throw the work on the spring-boot jpa to take the best strategy to choose and generated the value it will choose the generation type
  Ex : : : :  @GeneratedValue ( strategy = GenerationType.AUTO)
  
  TABLE
  This is use when you want to work on the independently when you want change in the database and no worry think about IDENTITY SEQUENCE AUTO ETC because table support in very database 
  Ex : : : : @GeneratedValue(strategy = GenerationType.TABLE, generator = "gen1")
  @TableGenerator(name = "gen1", table="id_customer_tb",  pkColumnName="pk_column",  pkColumnValue="id_val", valueColumnName="val_column" allocationSize = 1)
  
  CUSTOM EXAMPLE
  
  
  
 */
