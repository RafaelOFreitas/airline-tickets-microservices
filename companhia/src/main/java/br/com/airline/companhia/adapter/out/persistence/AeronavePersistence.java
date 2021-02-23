package br.com.airline.companhia.adapter.out.persistence;

import br.com.airline.companhia.core.application.port.out.AeronavePersistencePort;
import br.com.airline.companhia.core.domain.Aeronave;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
@Log4j2
public class AeronavePersistence implements AeronavePersistencePort {

  @Override
  public Aeronave adicionar(Aeronave aeronave) {
    return null;
  }

  @Override
  public Aeronave buscar(Integer id) {
    return null;
  }

  @Override
  public Aeronave atualizar(Integer id, Aeronave aeronave) {
    return null;
  }
}