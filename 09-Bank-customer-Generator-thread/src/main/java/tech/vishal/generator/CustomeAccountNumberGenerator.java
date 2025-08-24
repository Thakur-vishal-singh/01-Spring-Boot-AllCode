package tech.vishal.generator;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import tech.vishal.repository.BankAccountRepository;

public class CustomeAccountNumberGenerator implements IdentifierGenerator{

	private BankAccountRepository repository;

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
