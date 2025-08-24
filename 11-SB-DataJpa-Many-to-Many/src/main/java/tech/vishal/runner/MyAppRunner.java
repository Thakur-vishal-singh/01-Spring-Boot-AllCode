package tech.vishal.runner;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import tech.vishal.entity.Author;
import tech.vishal.entity.Book;
import tech.vishal.service.BookService;

@Component
public class MyAppRunner implements ApplicationRunner {

	@Autowired
	BookService service;
	
	@Transactional // when we are doing the many task like delete insert and update we have to use the @Transcitonal beacuse if anything wrong it will undo the save means rollback 
	@Override
	public void run(ApplicationArguments args) throws Exception {
		saveBook();
		
		loadBook(1L);
		
		removeBook(1L);// this we are keeping side now we will see later about this sir said 
		
		
		
	}

	private void removeBook(long l) {

		service.removeBook(l);
	}

	private void loadBook(long l) {
	
//		List<Book> book = (List<Book>) service.loadBook(1l);
		
//		book.forEach(System.out::println);
		Book book = service.loadBook(l);
		System.out.println("book id ::::"+book.getId()+" book name ::::"+book.getName());
		List<Author> authors = book.getAuthors();
		for(Author author : authors) {
			System.out.println("author id ::::"+author.getId()+" author name ::::"+author.getName());
		}
		
	}

	
	private void saveBook() {
	    Book book1 = new Book(null, "Java", null);
	    Book book2 = new Book(null, "Spring", null);

	    Author author1 = new Author(null, "James", null);
	    Author author2 = new Author(null, "John", null);
	    Author author3 = new Author(null, "Jeffery", null);

	    book1 = service.addAuthors(book1, List.of(author1, author2, author3));
	    book2 = service.addAuthors(book2, List.of(author1, author3));

	    book1 = service.saveBook(book1);
	    book2 = service.saveBook(book2);

	    System.out.println("Books inserted: book1 ID = " + book1.getId() + ", book2 ID = " + book2.getId());
	}

	
	
	
	
	
//	private void saveBook() {
//		
//		Book book1 = new Book();
//		book1.setName("java");
//	
//		Book book2 = new Book();
//		book2.setName("spring");
//		
//		Author author1 = new Author();
//		author1.setName("james");
//		
//		Author author2 = new Author();
//		author2.setName("jhon");
//		
//		Author author3 = new Author();
//		author3.setName("jeffery");
//		
//		
//		List<Author> authorsForBook1 = Arrays.asList(author1,author2,author3);
//		List<Author> authorsForBook2 = Arrays.asList(author1,author3);
//
//		book1 = service.addAuthors(book1, authorsForBook1);
//		book2 = service.addAuthors(book2, authorsForBook2);
//		
//		book1 = service.saveBook(book1);
//		book2 = service.saveBook(book2);
//		
//		System.out.println("the books with authors are inserted into the the database");
//		System.out.println("the id of the book1 ::::"+book1.getId());
//		System.out.println("the id of the book2 ::::"+book2.getId());
//		
//		
//	}

}
