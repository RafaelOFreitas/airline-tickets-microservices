package br.com.airline.funcionario.adapter.in.web.mapper;

import br.com.airline.funcionario.adapter.in.web.dto.input.FuncionarioInput;
import br.com.airline.funcionario.adapter.in.web.dto.output.FuncionarioOutput;
import br.com.airline.funcionario.core.domain.Funcionario;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class FuncionarioMapper {

  private final ModelMapper modelMapper;

  public Funcionario toDomain(FuncionarioInput input) {
    return this.modelMapper.map(input, Funcionario.class);
  }

  public FuncionarioOutput toOutput(Funcionario domain) {
    return this.modelMapper.map(domain, FuncionarioOutput.class);
  }

  public List<FuncionarioOutput> toOutput(List<Funcionario> funcionarios) {
    return funcionarios
        .stream()
        .map(this::toOutput)
        .collect(Collectors.toList());
  }
}
