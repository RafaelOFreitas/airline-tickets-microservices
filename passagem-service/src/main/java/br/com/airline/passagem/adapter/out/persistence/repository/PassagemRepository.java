package br.com.airline.passagem.adapter.out.persistence.repository;

import br.com.airline.passagem.adapter.out.persistence.entity.PassagemEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PassagemRepository extends MongoRepository<PassagemEntity, String> {

}
