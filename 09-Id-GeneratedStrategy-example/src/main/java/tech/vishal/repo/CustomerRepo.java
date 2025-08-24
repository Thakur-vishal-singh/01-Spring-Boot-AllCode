package tech.vishal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tech.vishal.entity.CustomerEntity;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer>{


	@Query(name = "CustomerEntity.getEmail", nativeQuery = true)
	CustomerEntity getEmail(@Param("data") String email);
	
//	@Query(name="CustomerEntity.fetchAllWithoutResultset", nativeQuery = true)
//	List<Object[]> getAll();
	
	
	@Query(name="CustomerEntity.fetchAllWithoutResultset", nativeQuery = true)
	List<CustomerEntity> getAll();
	
	
}
