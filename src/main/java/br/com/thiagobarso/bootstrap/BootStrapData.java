package br.com.thiagobarso.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.thiagobarso.domain.Author;
import br.com.thiagobarso.domain.Book;
import br.com.thiagobarso.domain.Publisher;
import br.com.thiagobarso.repositories.AuthorRepository;
import br.com.thiagobarso.repositories.BookRepository;
import br.com.thiagobarso.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(
			AuthorRepository authorRepository,
			BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Started in Bootstrap");
		
		
		Publisher publisher = new Publisher();
		publisher.setName("Pipoca Publications");
		publisher.setCity("New Jersey");
		publisher.setState("NY");
		
		publisherRepository.save(publisher);
		
		Author author = new Author("Dan", "Brown");
		Book book = new Book("Da Vinci Code","123123");
		author.getBooks().add(book);
		book.getAuthors().add(author);
		
		book.setPublisher(publisher);
		publisher.getBooks().add(book);
		
		authorRepository.save(author);
		bookRepository.save(book);
		publisherRepository.save(publisher);
		
		Author author2 = new Author("Michael", "Jackson");
		Book book2 = new Book("Moonwalker","123124");
		author2.getBooks().add(book2);
		book2.getAuthors().add(author2);
		
		book2.setPublisher(publisher);
		publisher.getBooks().add(book2);
		
		authorRepository.save(author2);
		bookRepository.save(book2);
		publisherRepository.save(publisher);		
		
		System.out.println("Number of books: " + bookRepository.count());
		System.out.println("Publisher Number of Books: " + publisher.getBooks().size());

	}

}
