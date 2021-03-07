package br.com.airline.companhia.core.application.service;

import br.com.airline.companhia.core.application.port.in.RotaServicePort;
import br.com.airline.companhia.core.application.port.out.RotaPersistencePort;
import br.com.airline.companhia.core.domain.Rota;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RotaService implements RotaServicePort {

  private final RotaPersistencePort rotaPersistence;

  @Override
  public Rota adicionar(UUID idCompanhia, Rota rota) {
    return this.rotaPersistence.adicionar(idCompanhia, rota);
  }

  @Override
  public Set<Rota> buscar(UUID idCompanhia) {
    return this.rotaPersistence.buscar(idCompanhia);
  }

  @Override
  public Rota atualizar(UUID idCompanhia, Rota rota) {
    return this.rotaPersistence.atualizar(idCompanhia, rota);
  }
}
