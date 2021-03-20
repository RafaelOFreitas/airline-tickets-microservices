package br.com.airline.companhia.core.application.port.out;

import br.com.airline.companhia.core.domain.Rota;
import java.util.UUID;

public interface ViewPersistencePort {

  Rota buscar(UUID idCompanhia, Integer idRota, String matricula);
}