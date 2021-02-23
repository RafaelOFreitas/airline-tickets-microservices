package br.com.airline.companhia.adapter.out.persistence;

import br.com.airline.companhia.core.application.port.out.RotaPersistencePort;
import br.com.airline.companhia.core.domain.Rota;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
@Log4j2
public class RotaPersistence implements RotaPersistencePort {

  @Override
  public Rota adicionar(Rota rota) {
    return null;
  }

  @Override
  public Rota buscar(UUID id) {
    return null;
  }

  @Override
  public Rota atualizar(Rota rota) {
    return null;
  }
}