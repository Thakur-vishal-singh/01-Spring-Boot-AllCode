package tech.vishal.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tech.vishal.entity.CustomerEntity;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer> {

	@Query(name="CustomerEntity.getName")
	CustomerEntity  getName(@Param(value = "userName") String userName);
	
	@Query(name="CustomerEntity.getEmail")
	CustomerEntity getEmail(@Param("email") String email );
	
	List<CustomerEntity> findAll();
	
	List<CustomerEntity>  findByNameContaining(String name);
	
	Optional<CustomerEntity> findByNumber(Long number);
	
	
}
