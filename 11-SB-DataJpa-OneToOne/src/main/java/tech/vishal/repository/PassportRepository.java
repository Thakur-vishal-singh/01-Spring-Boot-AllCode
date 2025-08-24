package tech.vishal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.vishal.entity.Passport;

public interface PassportRepository extends JpaRepository<Passport, String> {
	 boolean existsById(String id);
	    boolean existsByPassportNumber(String passportNumber);}
