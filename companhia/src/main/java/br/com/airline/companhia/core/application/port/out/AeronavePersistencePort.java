package br.com.airline.companhia.core.application.port.out;

import br.com.airline.companhia.core.domain.Aeronave;

public interface AeronavePersistencePort {

  Aeronave adicionar(Aeronave aeronave);

  Aeronave buscar(Integer id);

  Aeronave atualizar(Integer id, Aeronave aeronave);
}