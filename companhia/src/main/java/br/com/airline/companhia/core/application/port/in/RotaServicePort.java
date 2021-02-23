package br.com.airline.companhia.core.application.port.in;

import br.com.airline.companhia.core.domain.Rota;
import java.util.UUID;

public interface RotaServicePort {

  Rota adicionar(Rota rota);

  Rota buscar(UUID id);

  Rota atualizar(Rota rota);
}
