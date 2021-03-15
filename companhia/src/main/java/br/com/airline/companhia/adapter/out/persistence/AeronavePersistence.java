package br.com.airline.companhia.adapter.out.persistence;

import br.com.airline.companhia.adapter.out.persistence.entity.AeronaveEntityId;
import br.com.airline.companhia.adapter.out.persistence.mapper.AeronaveEntityMapper;
import br.com.airline.companhia.adapter.out.persistence.repository.AeronaveRepository;
import br.com.airline.companhia.core.application.port.out.AeronavePersistencePort;
import br.com.airline.companhia.core.domain.Aeronave;
import br.com.airline.companhia.core.domain.exception.AeronaveNotFoundException;
import br.com.airline.companhia.core.domain.exception.NegocioException;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
@Log4j2
public class AeronavePersistence implements AeronavePersistencePort {

  private final AeronaveRepository repository;
  private final AeronaveEntityMapper mapper;

  @Transactional
  @Override
  public Aeronave adicionar(UUID idCompanhia, Integer idRota, Aeronave aeronave) {
    log.info("Iniciando transação para salvar aeronave: " + aeronave.toString());

    this.repository
        .findById(new AeronaveEntityId(aeronave.getMatricula(), idCompanhia, idRota))
        .ifPresent(entity -> {
          log.info("Aeronave já cadastrada: " + aeronave.toString());
          throw new NegocioException("Aeronave já cadastrada: " + aeronave.getMatricula());
        });

    var aeronaveEntity = this.mapper.toEntity(aeronave, idCompanhia, idRota);

    aeronaveEntity = this.repository.saveAndFlush(aeronaveEntity);

    return this.mapper.toDomain(aeronaveEntity);
  }

  @Override
  public Aeronave buscar(UUID idCompanhia, Integer idRota, String matricula) {
    log.info("Iniciando transação para buscar aeronave: " + matricula);

    var aeronave = this.repository
        .findById(new AeronaveEntityId(matricula, idCompanhia, idRota))
        .orElseThrow(() -> new AeronaveNotFoundException(matricula));

    return this.mapper.toDomain(aeronave);
  }

  @Transactional
  @Override
  public Aeronave atualizar(UUID idCompanhia, Integer idRota, Aeronave aeronave) {
    log.info("Iniciando transação para atualizar dados da aeronave: " + aeronave.getMatricula());

    var entity = this.repository
        .findById(new AeronaveEntityId(aeronave.getMatricula(), idCompanhia, idRota))
        .orElseThrow(() -> new AeronaveNotFoundException(aeronave.getMatricula()));

    this.mapper.copyProperties(aeronave, entity);

    entity = this.repository.save(entity);

    return this.mapper.toDomain(entity);
  }

  @Transactional
  @Override
  public void salvar(UUID idCompanhia, Integer idRota, Aeronave aeronave) {
    log.info(String.format("Iniciando transação para %s a aeronave: %s",
        aeronave.getStatus(), aeronave.getMatricula()));

    this.repository.save(this.mapper.toEntity(aeronave, idCompanhia, idRota));
  }
}