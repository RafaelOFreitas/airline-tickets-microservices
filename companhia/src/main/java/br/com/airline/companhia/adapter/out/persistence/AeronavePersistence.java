package br.com.airline.companhia.adapter.out.persistence;

import br.com.airline.companhia.adapter.out.persistence.mapper.AeronaveEntityMapper;
import br.com.airline.companhia.adapter.out.persistence.repository.AeronaveRepository;
import br.com.airline.companhia.core.application.port.out.AeronavePersistencePort;
import br.com.airline.companhia.core.domain.Aeronave;
import br.com.airline.companhia.core.domain.exception.AeronaveNotFoundException;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
@Log4j2
public class AeronavePersistence implements AeronavePersistencePort {

  private final AeronaveRepository aeronaveRepository;
  private final AeronaveEntityMapper mapper;

  @Transactional
  @Override
  public Aeronave adicionar(Aeronave aeronave) {
    log.info("Iniciando transação para salvar aeronave: " + aeronave.getNome());

    var entity = this.mapper.toEntity(aeronave);

    entity = this.aeronaveRepository.saveAndFlush(entity);

    return this.mapper.toDomain(entity);
  }

  @Override
  public Aeronave buscar(UUID id) {
    log.info("Iniciando transação para buscar dados da aeronave: " + id);

    var entity = this.aeronaveRepository
        .findById(id)
        .orElseThrow(() -> new AeronaveNotFoundException(id));

    return this.mapper.toDomain(entity);
  }

  @Override
  public Aeronave atualizar(UUID id, Aeronave aeronave) {
    log.info("Iniciando transação para atualizar dados da aeronave: " + id);

    var entity = this.aeronaveRepository
        .findById(id)
        .orElseThrow(() -> new AeronaveNotFoundException(id));

    this.mapper.copyProperties(aeronave, entity);

    entity = this.aeronaveRepository.save(entity);

    return this.mapper.toDomain(entity);
  }

  @Transactional
  @Override
  public void atualizar(Aeronave aeronave) {
    log.info(String.format("Iniciando transação para %s a aeronave: %s",
        aeronave.getStatus(), aeronave.getId()));

    this.aeronaveRepository.save(this.mapper.toEntity(aeronave));
  }
}