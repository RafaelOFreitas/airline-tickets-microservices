package br.com.airline.vooquery.core.application.port.out;

import br.com.airline.vooquery.core.domain.Voo;
import java.util.UUID;

public interface VooPersistencePort {

  Voo adicionar(Voo voo);

  Voo atualizar(UUID idVoo, Voo voo);
}