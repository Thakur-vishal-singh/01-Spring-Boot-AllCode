package tech.vishal.service;

import java.util.List;

import tech.vishal.entity.Author;
import tech.vishal.entity.Book;

public interface BookService {

	Book addAuthors(Book books, List<Author> author);
	
	Book saveBook(Book book);
	
	Book loadBook(Long id);
	
	void removeBook(Long id);
	
}


