package tech.vishal.runner;

import lombok.RequiredArgsConstructor;
import tech.vishal.entity.Person;
import tech.vishal.entity.PersonGender;
import tech.vishal.service.PersonService;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final PersonService personService;

    @Override
    public void run(ApplicationArguments args) {
        Person person = Person.builder()
                .name("Amit Singh")
                .gender(PersonGender.MALE)
                .email("amit@example.com")
                .build();

        personService.createPersonWithPassport(person);
        
        
    }
}
