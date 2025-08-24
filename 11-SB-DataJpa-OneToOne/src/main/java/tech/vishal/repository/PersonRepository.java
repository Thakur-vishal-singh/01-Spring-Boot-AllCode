package tech.vishal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.vishal.entity.Person;

public interface PersonRepository extends JpaRepository<Person, String> {
    boolean existsById(String id);
}
