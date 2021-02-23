package br.com.airline.companhia.core.application.port.out;

import br.com.airline.companhia.core.domain.Rota;
import java.util.UUID;

public interface RotaPersistencePort {

  Rota adicionar(Rota rota);

  Rota buscar(UUID id);

  Rota atualizar(Rota rota);
}