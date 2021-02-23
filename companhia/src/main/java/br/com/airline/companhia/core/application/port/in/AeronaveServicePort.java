package br.com.airline.companhia.core.application.port.in;

import br.com.airline.companhia.core.domain.Aeronave;

public interface AeronaveServicePort {

  Aeronave adicionar(Aeronave aeronave);

  Aeronave buscar(Integer id);

  Aeronave atualizar(Aeronave aeronave);

  void excluir(Aeronave aeronave);
}
