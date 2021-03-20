package br.com.airline.companhia.adapter.out.persistence.repository;

import br.com.airline.companhia.adapter.out.persistence.entity.RotaEntity;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RotaRepository extends JpaRepository<RotaEntity, Integer> {

  Optional<RotaEntity> findByIdAndCompanhiaId(Integer id, UUID companhiaId);

  Optional<Set<RotaEntity>> findAllByCompanhiaId(UUID idCompanhia);
}