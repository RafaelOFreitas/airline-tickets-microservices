package br.com.airline.voocommand.core.application.service;

import br.com.airline.voocommand.core.application.port.in.VooServicePort;
import br.com.airline.voocommand.core.application.port.out.CompanhiaServicePort;
import br.com.airline.voocommand.core.application.port.out.MapaPersistencePort;
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
  private final MapaPersistencePort mapaPersistencePort;

  @Override
  public Voo adicionar(Voo voo) {
    var companhia = voo.getCompanhia();
    var rota = voo.getRota();
    var aeronave = voo.getAeronave();

    voo = this.companhiaService.buscarInformacoesAdicionais(companhia, rota, aeronave);

    voo = this.vooPersistencePort.adicionar(voo);

    voo.setMapa(this.mapaPersistencePort.adicionar(voo));

    return voo;
  }

  @Override
  public Voo atualizar(UUID idVoo, Voo voo) {
    return null;
  }
}
