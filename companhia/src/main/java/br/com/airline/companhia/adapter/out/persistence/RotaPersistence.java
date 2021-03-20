package br.com.airline.companhia.adapter.out.persistence;

import br.com.airline.companhia.adapter.out.persistence.mapper.RotaEntityMapper;
import br.com.airline.companhia.adapter.out.persistence.repository.RotaRepository;
import br.com.airline.companhia.core.application.port.out.RotaPersistencePort;
import br.com.airline.companhia.core.domain.Rota;
import br.com.airline.companhia.core.domain.exception.RotaNotFoundException;
import java.util.Set;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
@Log4j2
public class RotaPersistence implements RotaPersistencePort {

  private final RotaRepository repository;
  private final RotaEntityMapper mapper;
  private final CompanhiaPersistence companhiaPersistence;

  @Transactional
  @Override
  public Rota adicionar(UUID idCompanhia, Rota rota) {
    log.info("Iniciando transação para salvar rota: " + rota.toString());

    var companhiaEntity = this.companhiaPersistence.getCompanhiaEntity(idCompanhia);

    var rotaEntity = this.mapper.toEntity(rota);

    companhiaEntity.addRota(rotaEntity);

    rotaEntity = this.repository.saveAndFlush(rotaEntity);

    return this.mapper.toDomain(rotaEntity);
  }

  @Override
  public Set<Rota> buscar(UUID idCompanhia) {
    log.info("Iniciando transação para buscar rotas da companhia: " + idCompanhia);

    var rotas = this.repository
        .findAllByCompanhiaId(idCompanhia)
        .orElseThrow(() -> new RotaNotFoundException(idCompanhia));

    return this.mapper.toDomain(rotas);
  }

  @Transactional
  @Override
  public Rota atualizar(UUID idCompanhia, Rota rota) {
    Integer idRota = rota.getId();

    log.info("Iniciando transação para atualizar dados da rota: " + idRota);

    var rotaEntity = this.repository
        .findByIdAndCompanhiaId(idRota, idCompanhia)
        .orElseThrow(() -> new RotaNotFoundException(idRota));

    this.mapper.copyProperties(rota, rotaEntity);

    rotaEntity = this.repository.save(rotaEntity);

    return this.mapper.toDomain(rotaEntity);
  }
}