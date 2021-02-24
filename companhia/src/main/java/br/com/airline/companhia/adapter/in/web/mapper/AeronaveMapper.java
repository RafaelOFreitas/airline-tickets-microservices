package br.com.airline.companhia.adapter.in.web.mapper;

import br.com.airline.companhia.adapter.in.web.dto.input.AeronaveInput;
import br.com.airline.companhia.adapter.in.web.dto.output.AeronaveOutput;
import br.com.airline.companhia.core.domain.Aeronave;
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
}
