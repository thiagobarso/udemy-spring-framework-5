package br.com.thiagobarso.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.thiagobarso.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
