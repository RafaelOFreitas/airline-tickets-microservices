package br.com.airline.passagem.adapter.out.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.airline.passagem.adapter.out.persistence.entity.PassagemEntity;

public interface PassagemRepository  extends MongoRepository<PassagemEntity, String>{

}
