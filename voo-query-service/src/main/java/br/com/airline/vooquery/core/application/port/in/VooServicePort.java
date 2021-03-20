package br.com.airline.vooquery.core.application.port.in;

import br.com.airline.vooquery.core.domain.Voo;
import java.util.UUID;

public interface VooServicePort {

  Voo adicionar(Voo voo);

  Voo atualizar(UUID idVoo, Voo voo);
}
