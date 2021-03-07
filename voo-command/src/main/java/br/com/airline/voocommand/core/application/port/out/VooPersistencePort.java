package br.com.airline.voocommand.core.application.port.out;

import br.com.airline.voocommand.core.domain.Voo;
import java.util.UUID;

public interface VooPersistencePort {

  Voo adicionar(Voo voo);

  Voo atualizar(UUID idVoo, Voo voo);
}