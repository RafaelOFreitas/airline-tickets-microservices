package br.com.airline.companhia.adapter.in.web.mapper;

import br.com.airline.companhia.adapter.in.web.dto.input.AeronaveInput;
import br.com.airline.companhia.adapter.in.web.dto.output.AeronaveOutput;
import br.com.airline.companhia.core.domain.Aeronave;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AeronaveMapper {

  private final ModelMapper modelMapper;

  public Aeronave toDomain(AeronaveInput input) {
    return this.modelMapper.map(input, Aeronave.class);
  }

  public AeronaveOutput toOutput(Aeronave domain) {
    return this.modelMapper.map(domain, AeronaveOutput.class);
  }

  public List<AeronaveOutput> toOutput(List<Aeronave> domains) {
    if (Objects.isNull(domains)) {
      return Collections.emptyList();
    }

    return domains.stream().map(this::toOutput).collect(Collectors.toList());
  }
}
