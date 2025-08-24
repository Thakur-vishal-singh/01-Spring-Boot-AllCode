package tech.vishal.generator;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import tech.vishal.repository.BankAccountRepository;

public class CustomeAccountNumberGenerator implements IdentifierGenerator{

	@Autowired
	BankAccountRepository repository;
	
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		
		String branchCode = branchCode();
		
		String year =String.valueOf(LocalDate.now().getYear());// precent date 

		String prefix = branchCode() + year; 
		
		Long count = repository.countByPrefix(prefix);
		
		String sequence = String.format("%06d", count + 1);
		
		return prefix + sequence;
	}

	
	private String branchCode() {
		return "2231";
}
	
	
	
	
	
}
