package br.com.thiagobarso.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.thiagobarso.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
