package br.com.airline.voocommand.adapter.out.integration;

import br.com.airline.voocommand.adapter.out.integration.client.CompanhiaClient;
import br.com.airline.voocommand.adapter.out.integration.mapper.CompanhiaMapper;
import br.com.airline.voocommand.core.application.port.out.CompanhiaServicePort;
import br.com.airline.voocommand.core.domain.Voo;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CompanhiaService implements CompanhiaServicePort {

  private final CompanhiaClient client;
  private final CompanhiaMapper mapper;

  @Override
  public Voo buscarInformacoesAdicionais(UUID companhia, Integer rota, String aeronave) {
    var informacoesVoo = this.client.getInfo(companhia, rota, aeronave);

    var voo = this.mapper.toDomain(informacoesVoo);

    voo.setCompanhia(companhia);
    voo.setRota(rota);
    voo.setAeronave(aeronave);

    return voo;
  }
}