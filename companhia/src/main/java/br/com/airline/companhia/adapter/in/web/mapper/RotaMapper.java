package br.com.airline.companhia.adapter.in.web.mapper;

import br.com.airline.companhia.adapter.in.web.dto.input.RotaInput;
import br.com.airline.companhia.adapter.in.web.dto.output.RotaListOutput;
import br.com.airline.companhia.adapter.in.web.dto.output.RotaOutput;
import br.com.airline.companhia.core.domain.Rota;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class RotaMapper {

  private final ModelMapper modelMapper;

  public Rota toDomain(RotaInput input) {
    return this.modelMapper.map(input, Rota.class);
  }

  public Rota toDomain(Integer idRota, RotaInput input) {
    var rota = this.modelMapper.map(input, Rota.class);

    rota.setId(idRota);

    return rota;
  }

  public RotaOutput toOutput(Rota domain) {
    return this.modelMapper.map(domain, RotaOutput.class);
  }

  public RotaListOutput toOutput(UUID idCompanhia, List<Rota> domains) {
    if (Objects.isNull(domains)) {
      return new RotaListOutput(null, Collections.emptyList());
    }

    var rotas = domains.stream().map(this::toOutput).collect(Collectors.toList());

    return new RotaListOutput(idCompanhia, rotas);
  }
}
