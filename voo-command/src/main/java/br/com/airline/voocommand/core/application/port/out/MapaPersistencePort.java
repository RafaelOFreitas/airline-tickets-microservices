package br.com.airline.voocommand.core.application.port.out;

import br.com.airline.voocommand.core.domain.MapaVoo;
import br.com.airline.voocommand.core.domain.Voo;
import java.util.UUID;

public interface MapaPersistencePort {

  MapaVoo adicionar(Voo voo);

  MapaVoo atualizar(UUID idVoo, MapaVoo mapaVoo);
}