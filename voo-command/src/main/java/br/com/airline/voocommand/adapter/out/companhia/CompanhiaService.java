package br.com.airline.voocommand.adapter.out.companhia;

import br.com.airline.voocommand.adapter.out.companhia.client.CompanhiaClient;
import br.com.airline.voocommand.adapter.out.companhia.mapper.CompanhiaMapper;
import br.com.airline.voocommand.core.application.port.out.CompanhiaServicePort;
import br.com.airline.voocommand.core.domain.Voo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CompanhiaService implements CompanhiaServicePort {

  private final CompanhiaClient client;
  private final CompanhiaMapper mapper;

  @Override
  public Voo getInfo(Voo voo) {
    var companhia = voo.getIdCompanhia();
    var rota = voo.getIdRota();
    var aeronave = voo.getMatriculaAeronave();

    var dto = this.client.getInfo(companhia, rota, aeronave);

    return this.mapper.toDomain(voo, dto);
  }
}