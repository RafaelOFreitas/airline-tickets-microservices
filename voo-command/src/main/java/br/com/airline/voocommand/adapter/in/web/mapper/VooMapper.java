package br.com.airline.voocommand.adapter.in.web.mapper;

import br.com.airline.voocommand.adapter.in.web.dto.input.VooInput;
import br.com.airline.voocommand.adapter.in.web.dto.output.VooOutput;
import br.com.airline.voocommand.core.domain.Voo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class VooMapper {

  private final ModelMapper modelMapper;

  public Voo toDomain(VooInput input) {
    return this.modelMapper.map(input, Voo.class);
  }

  public VooOutput toOutput(Voo domain) {
    return this.modelMapper.map(domain, VooOutput.class);
  }
}
