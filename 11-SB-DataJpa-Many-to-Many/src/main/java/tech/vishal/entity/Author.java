package tech.vishal.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.TableGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Data
@Getter
@Setter
public class Author {

	
	@Id
	@TableGenerator(
			name = "author_linked_gen", 
			table="author_gen_id",
			pkColumnName="pk_column",
			pkColumnValue="pk_value", 
			valueColumnName="gen_value",
			allocationSize = 10
			)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "author_linked_gen")
	private Long id;
	
	private String  name;
	
	@ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)// mapped by tell it is the bip-direvtoon  
	List<Book> books;
	
}
