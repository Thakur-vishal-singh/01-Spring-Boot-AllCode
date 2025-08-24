package tech.vishal.entity;
//
//import java.time.LocalDate;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToOne;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//
//
//@Entity
//@NoArgsConstructor
//public class Passport {
//
//	@Id
//	private String passportNumber;
//	
//	
//	private LocalDate expireDate;
//	
////	@OneToOne(mappedBy = "passport")
//	private Person person;
//	
//}
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
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
public class Passport {

    @Id
    @GeneratedValue(generator = "uuid-gen")
    @GenericGenerator(name = "uuid-gen", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private String id;

    @Column(unique = true, nullable = false)
    private String passportNumber;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @PrePersist
    public void generatePassportNumber() {
        this.passportNumber = "P-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
