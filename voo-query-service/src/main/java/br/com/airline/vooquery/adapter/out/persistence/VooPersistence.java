package br.com.airline.vooquery.adapter.out.persistence;

import br.com.airline.vooquery.adapter.out.persistence.mapper.VooEntityMapper;
import br.com.airline.vooquery.adapter.out.persistence.repository.VooRepository;
import br.com.airline.vooquery.core.application.port.out.VooPersistencePort;
import br.com.airline.vooquery.core.domain.Voo;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
@Log4j2
public class VooPersistence implements VooPersistencePort {

  private final VooRepository repository;
  private final VooEntityMapper mapper;

  @Override
  public Voo adicionar(Voo voo) {
    log.info("Iniciando transação para salvar voo: " + voo.toString());

    var entity = this.mapper.toEntity(voo);

    entity = this.repository.save(entity);

    return this.mapper.toDomain(entity, voo.getMapa());
  }

  @Override
  public Voo atualizar(UUID idVoo, Voo voo) {
    return null;
  }
}

