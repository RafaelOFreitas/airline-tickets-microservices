package br.com.airline.companhia.adapter.out.persistence.repository;

import br.com.airline.companhia.adapter.out.persistence.entity.CompanhiaEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanhiaRepository extends JpaRepository<CompanhiaEntity, UUID> {

}