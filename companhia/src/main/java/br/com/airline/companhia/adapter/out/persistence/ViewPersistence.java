package br.com.airline.companhia.adapter.out.persistence;

import br.com.airline.companhia.adapter.out.persistence.entity.AeronaveEntityId;
import br.com.airline.companhia.adapter.out.persistence.mapper.AeronaveEntityMapper;
import br.com.airline.companhia.adapter.out.persistence.repository.AeronaveRepository;
import br.com.airline.companhia.core.application.port.out.ViewPersistencePort;
import br.com.airline.companhia.core.domain.Rota;
import br.com.airline.companhia.core.domain.exception.AeronaveNotFoundException;
import java.util.Collections;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
@Log4j2
public class ViewPersistence implements ViewPersistencePort {

  private final AeronaveRepository repository;
  private final AeronaveEntityMapper mapper;

  @Override
  public Rota buscar(UUID idCompanhia, Integer idRota, String matricula) {
    log.info(String.format("Recebendo requisição para buscar dados da companhia: %s "
        + "rota: %d e aeronave: %s", idCompanhia, idRota, matricula));

    var aeronave = this.repository
        .findById(new AeronaveEntityId(matricula, idCompanhia, idRota))
        .orElseThrow(() -> new AeronaveNotFoundException(matricula));

    var rota = aeronave.getRota();

    return Rota.builder()
        .id(rota.getId())
        .origem(rota.getOrigem())
        .destino(rota.getDestino())
        .dataRegistro(rota.getDataRegistro())
        .aeronaves(Collections.singleton(this.mapper.toDomain(aeronave)))
        .build();
  }
}