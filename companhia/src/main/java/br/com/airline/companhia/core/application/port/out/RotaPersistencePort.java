package br.com.airline.companhia.core.application.port.out;

import br.com.airline.companhia.core.domain.Rota;

public interface RotaPersistencePort {

  Rota adicionar(Rota rota);

  Rota buscar(Integer id);

  Rota atualizar(Rota rota);
}