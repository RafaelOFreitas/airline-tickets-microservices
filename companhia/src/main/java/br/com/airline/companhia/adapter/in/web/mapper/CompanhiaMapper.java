package br.com.airline.companhia.adapter.in.web.mapper;

import br.com.airline.companhia.adapter.in.web.dto.input.CompanhiaInput;
import br.com.airline.companhia.adapter.in.web.dto.output.CompanhiaOutput;
import br.com.airline.companhia.core.domain.Companhia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CompanhiaMapper {

  private final ModelMapper modelMapper;

  public Companhia toDomain(CompanhiaInput input) {
    return this.modelMapper.map(input, Companhia.class);
  }

  public CompanhiaOutput toOutput(Companhia domain) {
    return this.modelMapper.map(domain, CompanhiaOutput.class);
  }
}
