package br.com.airline.funcionario.adapter.in.web.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.airline.funcionario.adapter.in.web.dto.input.FuncionarioInput;
import br.com.airline.funcionario.adapter.in.web.dto.output.FuncionarioOutput;
import br.com.airline.funcionario.core.domain.Funcionario;
import lombok.AllArgsConstructor;

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
}
