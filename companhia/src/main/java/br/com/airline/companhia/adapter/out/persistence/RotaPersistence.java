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

  private final RotaRepository rotaRepository;
  private final CompanhiaPersistence companhiaPersistence;
  private final RotaEntityMapper mapper;

  @Transactional
  @Override
  public Rota adicionar(UUID idCompanhia, Rota rota) {
    log.info("Iniciando transação para salvar rota para companhia: " + idCompanhia);

    var companhiaEntity = this.companhiaPersistence.getCompanhiaEntity(idCompanhia);

    var rotaEntity = this.mapper.toEntity(rota);

    companhiaEntity.addRota(rotaEntity);

    rotaEntity = this.rotaRepository.saveAndFlush(rotaEntity);

    return this.mapper.toDomain(rotaEntity);
  }

  @Override
  public Set<Rota> buscar(UUID idCompanhia) {
    log.info("Iniciando transação para buscar rotas da companhia: " + idCompanhia);

    var rotas = this.rotaRepository
        .findAllByCompanhiaId(idCompanhia)
        .orElseThrow(() -> new RotaNotFoundException(idCompanhia));

    return this.mapper.toDomain(rotas);
  }

  @Transactional
  @Override
  public Rota atualizar(UUID idCompanhia, Rota rota) {
    Integer idRota = rota.getId();

    log.info("Iniciando transação para atualizar dados da rota: " + idRota);

    var rotaEntity = this.rotaRepository
        .findByIdAndCompanhiaId(idRota, idCompanhia)
        .orElseThrow(() -> new RotaNotFoundException(idRota));

    this.mapper.copyProperties(rota, rotaEntity);

    rotaEntity = this.rotaRepository.save(rotaEntity);

    return this.mapper.toDomain(rotaEntity);
  }
}