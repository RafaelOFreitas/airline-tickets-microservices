package br.com.airline.voocommand.adapter.out.persistence;

import br.com.airline.voocommand.core.application.port.out.VooPersistencePort;
import br.com.airline.voocommand.core.domain.Voo;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
@Log4j2
public class VooPersistence implements VooPersistencePort {

  @Override
  public Voo adicionar(Voo voo) {
    return null;
  }

  @Override
  public Voo atualizar(UUID idVoo, Voo voo) {
    return null;
  }
}