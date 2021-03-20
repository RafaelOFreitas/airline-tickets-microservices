package br.com.airline.companhia.adapter.in.web.mapper;

import br.com.airline.companhia.adapter.in.web.dto.view.output.AeronaveViewOutput;
import br.com.airline.companhia.adapter.in.web.dto.view.output.RotaViewOutput;
import br.com.airline.companhia.adapter.in.web.dto.view.output.ViewOutput;
import br.com.airline.companhia.core.domain.Rota;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@AllArgsConstructor
@Component
public class ViewMapper {

  private final ModelMapper modelMapper;

  public ViewOutput toOutput(Rota domain) {
    var aeronave = CollectionUtils.firstElement(domain.getAeronaves());

    var rota = RotaViewOutput.builder()
        .origem(domain.getOrigem())
        .destino(domain.getDestino())
        .aeronave(this.modelMapper.map(aeronave, AeronaveViewOutput.class))
        .build();

    return new ViewOutput(rota);
  }
}
