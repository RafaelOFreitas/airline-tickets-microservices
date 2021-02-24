package br.com.airline.companhia.core.application.port.in;

import br.com.airline.companhia.core.domain.Aeronave;
import java.util.UUID;

public interface AeronaveServicePort {

  Aeronave adicionar(Aeronave aeronave);

  Aeronave buscar(UUID id);

  Aeronave atualizar(UUID id, Aeronave aeronave);

  void ativar(UUID id);

  void inativar(UUID id);
}
