package tech.vishal.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tech.vishal.entity.CustomerEntity;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer> {

	
	Optional<CustomerEntity> findByName(String name);

	@Query(name="select c from customerEntity c where c.customerId = :customerId Or c.createDate = :createDate")
	List<CustomerEntity> findByCustomerIdOrCreateDate(@Param("customerId") Integer id,@Param("createDate")  LocalDate createDate);
	
	
	@Query(name="Select * from customer where email_id = ?1 AND password= ?2", nativeQuery = true)
	CustomerEntity findByEmailIdAndPassword(String Email, String password);
	
//	@Query(name="select customer_Id, count(customerId) from orders2 group by customer_Id")
//	List<Object[]> fetchOrdersCountByCustomerId();
	
	@Query(name = "select c from CustomerEntity c where phoneNo= :phoneNone ")
	Optional<CustomerEntity> findByPhoneNo(@Param("phoneNo") String phoneNo);
	
}

//package tech.vishal.repo;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import tech.vishal.entity.CustomerEntity;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer> {
//	List<CustomerEntity>  findByName(String name);
//    CustomerEntity findByNameAndPassword(String name, String password);
//}    