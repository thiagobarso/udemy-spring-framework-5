package br.com.thiagobarso.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.thiagobarso.domain.Author;
import br.com.thiagobarso.domain.Book;
import br.com.thiagobarso.repositories.AuthorRepository;
import br.com.thiagobarso.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		Author author = new Author("Dan", "Brown");
		Book book = new Book("Da Vinci Code","123123");
		author.getBooks().add(book);
		book.getAuthors().add(author);
		
		authorRepository.save(author);
		bookRepository.save(book);
		
		Author author2 = new Author("Michael", "Jackson");
		Book book2 = new Book("Moonwalker","123124");
		author2.getBooks().add(book2);
		book2.getAuthors().add(author2);
		
		authorRepository.save(author2);
		bookRepository.save(book2);
		
		System.out.println("Started in bootstrap");
		System.out.println("Number of books: " + bookRepository.count());

	}

}
