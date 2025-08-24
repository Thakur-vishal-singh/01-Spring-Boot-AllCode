package tech.vishal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tech.vishal.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount,  String> {

	@Query("select count(b) from BankAccount b where b.accountNumber like Concat(:prefix, '%')")
	Long countByPrefix(@Param("prefix") String prefix);
	
	
	
}
