package tech.vishal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tech.vishal.entity.CustomerEntity;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer>{

	@Query(name="CustomerEntity.login")
	public CustomerEntity login(@Param("mail") String email, @Param("name") String name);
	
	
	@Query(name="CustomerEntity.getByNumber")
	public List<CustomerEntity> getByNumber(@Param("phno") Long number);
}
//name="CustomerEntity.getByNumber",
//query="select c from CustomerEntity c where e.number = :phno"

