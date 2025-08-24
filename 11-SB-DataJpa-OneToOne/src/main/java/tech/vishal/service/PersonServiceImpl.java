package tech.vishal.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tech.vishal.entity.Passport;
import tech.vishal.entity.Person;
import tech.vishal.repository.PassportRepository;
import tech.vishal.repository.PersonRepository;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

	  private final PersonRepository personRepository;
	    private final PassportRepository passportRepository;
 
	    @Override
	    public void createPersonWithPassport(Person person) {
	        // Create Passport instance
	        Passport passport = new Passport();
	        passport.setPerson(person);

	        // Set both sides
	        person.setPassport(passport);

	        // Save person (passport will cascade)
	        personRepository.save(person);
	    }
}
