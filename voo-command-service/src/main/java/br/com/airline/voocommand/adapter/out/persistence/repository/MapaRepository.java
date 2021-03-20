package br.com.airline.voocommand.adapter.out.persistence.repository;


import br.com.airline.voocommand.adapter.out.persistence.entity.MapaVooEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MapaRepository extends MongoRepository<MapaVooEntity, String> {

}