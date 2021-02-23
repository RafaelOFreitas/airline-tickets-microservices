package br.com.airline.companhia.adapter.out.persistence.repository;

import br.com.airline.companhia.adapter.out.persistence.entity.RotaEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RotaRepository extends JpaRepository<RotaEntity, UUID> {

}