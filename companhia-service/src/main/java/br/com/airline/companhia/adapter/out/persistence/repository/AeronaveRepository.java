package br.com.airline.companhia.adapter.out.persistence.repository;

import br.com.airline.companhia.adapter.out.persistence.entity.AeronaveEntity;
import br.com.airline.companhia.adapter.out.persistence.entity.AeronaveEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AeronaveRepository extends JpaRepository<AeronaveEntity, AeronaveEntityId> {

}