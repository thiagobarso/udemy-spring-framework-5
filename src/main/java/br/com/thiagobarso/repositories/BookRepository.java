package br.com.thiagobarso.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.thiagobarso.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
