package br.com.airline.voocommand.adapter.out.persistence;

import br.com.airline.voocommand.adapter.out.persistence.mapper.MapaVooEntityMapper;
import br.com.airline.voocommand.adapter.out.persistence.repository.MapaRepository;
import br.com.airline.voocommand.core.application.port.out.MapaPersistencePort;
import br.com.airline.voocommand.core.domain.MapaVoo;
import br.com.airline.voocommand.core.domain.Voo;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
@Log4j2
public class MapaPersistence implements MapaPersistencePort {

  private final MapaRepository repository;
  private final MapaVooEntityMapper mapper;

  @Override
  public MapaVoo adicionar(Voo voo) {
    log.info("Iniciando transação para salvar mapa do voo: " + voo.getId());

    var entity = this.mapper.toEntity(voo);

    entity = this.repository.save(entity);

    return this.mapper.toDomain(entity);
  }

  @Override
  public MapaVoo atualizar(UUID idVoo, MapaVoo mapaVoo) {
    return null;
  }
}