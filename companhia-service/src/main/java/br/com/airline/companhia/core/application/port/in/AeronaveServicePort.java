package br.com.airline.companhia.core.application.port.in;

import br.com.airline.companhia.core.domain.Aeronave;
import java.util.UUID;

public interface AeronaveServicePort {

  Aeronave adicionar(UUID idCompanhia, Integer idRota, Aeronave aeronave);

  Aeronave buscar(UUID idCompanhia, Integer idRota, String matricula);

  Aeronave atualizar(UUID idCompanhia, Integer idRota, Aeronave aeronave);

  void ativar(UUID idCompanhia, Integer idRota, String matricula);

  void inativar(UUID idCompanhia, Integer idRota, String matricula);
}
