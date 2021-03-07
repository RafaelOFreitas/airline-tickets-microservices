package br.com.airline.voocommand.core.application.service;

import br.com.airline.voocommand.core.application.port.in.VooServicePort;
import br.com.airline.voocommand.core.application.port.out.CompanhiaServicePort;
import br.com.airline.voocommand.core.application.port.out.VooPersistencePort;
import br.com.airline.voocommand.core.domain.Voo;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VooService implements VooServicePort {

  private final CompanhiaServicePort companhiaService;
  private final VooPersistencePort vooPersistencePort;

  @Override
  public Voo adicionar(Voo voo) {
    voo = this.companhiaService.getInfo(voo);

    return voo;//this.vooPersistencePort.adicionar(voo);
  }

  @Override
  public Voo atualizar(UUID idVoo, Voo voo) {
    return null;
  }
}
