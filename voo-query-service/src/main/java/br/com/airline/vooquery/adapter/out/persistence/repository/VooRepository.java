package br.com.airline.vooquery.adapter.out.persistence.repository;

import br.com.airline.vooquery.adapter.out.persistence.entity.VooEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VooRepository extends MongoRepository<VooEntity, String> {

}