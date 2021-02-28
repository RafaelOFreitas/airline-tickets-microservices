package br.com.airline.companhia.core.application.port.out;

import br.com.airline.companhia.core.domain.Aeronave;
import java.util.UUID;

public interface AeronavePersistencePort {

  Aeronave adicionar(UUID idCompanhia, Integer idRota, Aeronave aeronave);

  Aeronave buscar(UUID idCompanhia, Integer idRota, String matricula);

  Aeronave atualizar(UUID idCompanhia, Integer idRota, Aeronave aeronave);

  void salvar(UUID idCompanhia, Integer idRota, Aeronave aeronave);
}