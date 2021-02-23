package br.com.airline.companhia.core.application.port.in;

import br.com.airline.companhia.core.domain.Rota;

public interface RotaServicePort {

  Rota adicionar(Rota rota);

  Rota buscar(Integer id);

  Rota atualizar(Rota rota);
}
