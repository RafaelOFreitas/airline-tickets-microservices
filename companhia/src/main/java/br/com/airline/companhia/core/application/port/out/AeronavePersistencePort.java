package br.com.airline.companhia.core.application.port.out;

import br.com.airline.companhia.core.domain.Aeronave;
import java.util.UUID;

public interface AeronavePersistencePort {

  Aeronave adicionar(Aeronave aeronave);

  Aeronave buscar(UUID id);

  Aeronave atualizar(UUID id, Aeronave aeronave);
}