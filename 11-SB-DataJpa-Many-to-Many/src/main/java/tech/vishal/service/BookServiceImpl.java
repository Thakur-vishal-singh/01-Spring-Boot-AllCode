package tech.vishal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import tech.vishal.entity.Author;
import tech.vishal.entity.Book;
import tech.vishal.repository.AuthorRepository;
import tech.vishal.repository.BookRepository;


@Service
public class BookServiceImpl implements BookService {

	
	@Autowired
	BookRepository bookRepo; 
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Override
	public Book addAuthors(Book books, List<Author> author) {
		books.setAuthors(author);
		return books;
	}

	@Override
	public Book saveBook(Book book) {
		book = bookRepo.save(book);
		return book;
	}

	@Override
	public Book loadBook(Long id) {
	    return bookRepo.findById(id)
	        .orElseThrow(() -> new RuntimeException("Book not found with id " + id));
	}
//	@Override
//	public Book loadBook(Long id) {
//	Book book = 	bookRepo.findById(id).get();
//		return book;
//	}

	@Override
	public void removeBook(Long id) {
		bookRepo.deleteById(id);
	}

	
//	public void deleteAuthor(Long authorId) {
//	    // Fetch the author entity
//	    Author author = authorRepository.findById(authorId)
//	        .orElseThrow(() -> new EntityNotFoundException ("Author not found"));
//
//	    // Remove the author from all associated books
//	    for (Book book : author.getBooks()) {
//	        book.getAuthors().remove(author);
//	    }
//
//	    // Now delete the author
//	    authorRepository.delete(author);
//	}
	

}
