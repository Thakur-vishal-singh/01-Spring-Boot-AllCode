package tech.vishal.service;

import java.io.OptionalDataException;
import java.util.Optional;

import tech.vishal.entity.Person;

public interface PersonService {

	public void createPersonWithPassport(Person person);
	
}
