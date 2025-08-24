package tech.vishal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.vishal.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
