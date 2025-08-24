package tech.vishal.entity;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToOne;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//
//@Entity
//@NoArgsConstructor
//public class Person {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//	
//	private String name;
//	
//	@Enumerated(EnumType.STRING)
//	private PersonGender gender;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="passwordNumber")
//	private Passport passport;
//	
//	
//}
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter  
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    @Id
    @GeneratedValue(generator = "uuid-gen")
    @GenericGenerator(name = "uuid-gen", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private String id;

    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private PersonGender gender;
    
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private Passport passport;
}
