package br.com.airline.vooquery.core.application.port.out;

import br.com.airline.vooquery.core.domain.MapaVoo;
import br.com.airline.vooquery.core.domain.Voo;
import java.util.UUID;

public interface MapaPersistencePort {

  MapaVoo adicionar(Voo voo);

  MapaVoo atualizar(UUID idVoo, MapaVoo mapaVoo);
}