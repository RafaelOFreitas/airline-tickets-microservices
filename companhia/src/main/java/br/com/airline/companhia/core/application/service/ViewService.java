package br.com.airline.companhia.core.application.service;

import br.com.airline.companhia.core.application.port.in.ViewServicePort;
import br.com.airline.companhia.core.application.port.out.ViewPersistencePort;
import br.com.airline.companhia.core.domain.Rota;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ViewService implements ViewServicePort {

  private final ViewPersistencePort viewPersistence;

  @Override
  public Rota buscar(UUID idCompanhia, Integer idRota, String matricula) {
    return this.viewPersistence.buscar(idCompanhia, idRota, matricula);
  }
}
