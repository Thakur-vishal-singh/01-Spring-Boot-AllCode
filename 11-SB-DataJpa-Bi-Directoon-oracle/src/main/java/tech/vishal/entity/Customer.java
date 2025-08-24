package tech.vishal.entity;

import java.util.List;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="customers")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "link_seq" )
	@SequenceGenerator(name="link_seq", sequenceName="customers_tb_seq", allocationSize = 1 )
	private Integer customerid;
	
	private String name;
	
	private String number;
	
	private String gmail;
	
	
	@OneToMany( mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	List<Orders> orders;
	
	
}
