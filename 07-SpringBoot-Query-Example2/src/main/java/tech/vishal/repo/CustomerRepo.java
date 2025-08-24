package tech.vishal.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.vishal.entity.CustomerEntity;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer>{

//	@Query(value="select * from customer where name = ?1 & password = ?2 ", nativeQuery = true )
	CustomerEntity findByNameAndPassword(String name, String password);
	
	Optional<CustomerEntity> findByName(String customerName);

//	Iterable<CustomerEntity> saveAll(CustomerEntity customer);

}
