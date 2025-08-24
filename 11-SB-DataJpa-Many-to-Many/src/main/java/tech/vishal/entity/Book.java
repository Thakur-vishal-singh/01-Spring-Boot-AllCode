package tech.vishal.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(																											// this will create  the table to store the two forgin key because there is no direct way to store the data many to many we will store in one table and join table need in the manytomany only not in manytoone onetoone etc
			name= "BOOK_AUTHOR", 																		// this is the name of the table we are going to create for store the join columns.
			joinColumns =  @JoinColumn(name = "BOOK_ID"), 								//here we are saying  this table is mapped with book table and it's a forgein key
			inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID") 			//  in anothor table called author it is forgein key 
			)
	private List<Author> authors;
	
}
