package br.com.airline.companhia.adapter.out.persistence;

import br.com.airline.companhia.core.application.port.out.CompanhiaPersistencePort;
import br.com.airline.companhia.core.domain.Companhia;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
@Log4j2
public class CompanhiaPersistence implements CompanhiaPersistencePort {

  @Override
  public Companhia adicionar(Companhia companhia) {
    return null;
  }

  @Override
  public Companhia buscar(Integer id) {
    return null;
  }

  @Override
  public Companhia atualizar(Integer id, Companhia companhia) {
    return null;
  }
}
