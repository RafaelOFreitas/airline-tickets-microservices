package br.com.airline.companhia.core.application.service;

import br.com.airline.companhia.core.application.port.in.RotaServicePort;
import br.com.airline.companhia.core.application.port.out.RotaPersistencePort;
import br.com.airline.companhia.core.domain.Rota;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RotaService implements RotaServicePort {

  private final RotaPersistencePort rotaPersistence;

  @Override
  public Rota adicionar(Rota rota) {
    return this.rotaPersistence.adicionar(rota);
  }

  @Override
  public Rota buscar(Integer id) {
    return this.rotaPersistence.buscar(id);
  }

  @Override
  public Rota atualizar(Rota rota) {
    return this.rotaPersistence.atualizar(rota);
  }
}
