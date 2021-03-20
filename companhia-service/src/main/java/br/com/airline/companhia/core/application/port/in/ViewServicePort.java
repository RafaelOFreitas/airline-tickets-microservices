package br.com.airline.companhia.core.application.port.in;

import br.com.airline.companhia.core.domain.Rota;
import java.util.UUID;

public interface ViewServicePort {

  Rota buscar(UUID idCompanhia, Integer idRota, String matricula);
}
