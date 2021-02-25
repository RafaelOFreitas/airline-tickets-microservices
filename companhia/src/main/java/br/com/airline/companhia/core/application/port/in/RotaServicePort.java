package br.com.airline.companhia.core.application.port.in;

import br.com.airline.companhia.core.domain.Rota;
import java.util.List;
import java.util.UUID;

public interface RotaServicePort {

  Rota adicionar(UUID idCompanhia, Rota rota);

  List<Rota> buscar(UUID idCompanhia);

  Rota atualizar(UUID idCompanhia, Rota rota);
}
