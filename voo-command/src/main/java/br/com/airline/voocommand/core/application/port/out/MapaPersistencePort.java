package br.com.airline.voocommand.core.application.port.out;

import br.com.airline.voocommand.core.domain.MapaVoo;
import java.util.UUID;

public interface MapaPersistencePort {

  MapaVoo adicionar(String idVoo, MapaVoo mapaVoo);

  MapaVoo atualizar(UUID idVoo, MapaVoo mapaVoo);
}