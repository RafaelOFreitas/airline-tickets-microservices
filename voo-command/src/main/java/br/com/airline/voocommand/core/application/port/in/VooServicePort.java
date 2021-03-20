package br.com.airline.voocommand.core.application.port.in;

import br.com.airline.voocommand.core.domain.Voo;
import java.util.UUID;

public interface VooServicePort {

  Voo adicionar(Voo voo);

  Voo atualizar(UUID idVoo, Voo voo);
}
