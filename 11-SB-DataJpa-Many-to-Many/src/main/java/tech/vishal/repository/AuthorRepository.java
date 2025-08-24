package tech.vishal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.vishal.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
