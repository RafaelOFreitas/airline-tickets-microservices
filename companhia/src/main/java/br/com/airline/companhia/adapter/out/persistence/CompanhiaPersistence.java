package br.com.airline.companhia.adapter.out.persistence;

import br.com.airline.companhia.adapter.out.persistence.entity.CompanhiaEntity;
import br.com.airline.companhia.adapter.out.persistence.mapper.CompanhiaEntityMapper;
import br.com.airline.companhia.adapter.out.persistence.repository.CompanhiaRepository;
import br.com.airline.companhia.core.application.port.out.CompanhiaPersistencePort;
import br.com.airline.companhia.core.domain.Companhia;
import br.com.airline.companhia.core.domain.exception.CompanhiaNotFoundException;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
@Log4j2
public class CompanhiaPersistence implements CompanhiaPersistencePort {

  private final CompanhiaRepository companhiaRepository;
  private final CompanhiaEntityMapper mapper;

  @Transactional
  @Override
  public Companhia adicionar(Companhia companhia) {
    log.info("Iniciando transação para salvar companhia: " + companhia.toString());

    var companhiaEntity = this.mapper.toEntity(companhia);

    companhiaEntity = this.companhiaRepository.saveAndFlush(companhiaEntity);

    return this.mapper.toDomain(companhiaEntity);
  }

  @Override
  public Companhia buscar(UUID id) {
    log.info("Iniciando transação para buscar dados da companhia: " + id);

    var companhiaEntity = this.getCompanhiaEntity(id);

    return this.mapper.toDomain(companhiaEntity);
  }

  @Transactional
  @Override
  public Companhia atualizar(UUID id, Companhia companhia) {
    log.info("Iniciando transação para atualizar dados da companhia: " + id);

    var companhiaEntity = this.getCompanhiaEntity(id);

    this.mapper.copyProperties(companhia, companhiaEntity);

    companhiaEntity = this.companhiaRepository.save(companhiaEntity);

    return this.mapper.toDomain(companhiaEntity);
  }

  @Transactional
  @Override
  public void atualizar(Companhia companhia) {
    log.info(String.format("Iniciando transação para %s a companhia: %s",
        companhia.getStatus(), companhia.getId()));

    this.companhiaRepository.save(this.mapper.toEntity(companhia));
  }

  protected CompanhiaEntity getCompanhiaEntity(UUID id) {
    return this.companhiaRepository
        .findById(id)
        .orElseThrow(() -> new CompanhiaNotFoundException(id));
  }
}
