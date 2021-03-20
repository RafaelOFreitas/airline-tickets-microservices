package br.com.airline.vooquery.adapter.out.persistence.repository;

import br.com.airline.vooquery.adapter.out.persistence.entity.MapaVooEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MapaRepository extends MongoRepository<MapaVooEntity, String> {

}