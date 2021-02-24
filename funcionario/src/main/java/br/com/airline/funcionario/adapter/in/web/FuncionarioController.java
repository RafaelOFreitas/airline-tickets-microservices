package br.com.airline.funcionario.adapter.in.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.airline.funcionario.adapter.in.web.dto.input.FuncionarioInput;
import br.com.airline.funcionario.adapter.in.web.dto.output.FuncionarioOutput;
import br.com.airline.funcionario.adapter.in.web.mapper.FuncionarioMapper;
import br.com.airline.funcionario.core.application.port.in.FuncionarioServicePort;
import br.com.airline.funcionario.core.domain.Funcionario;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Log4j2
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	private final FuncionarioServicePort funcionarioService;
	private final FuncionarioMapper mapper;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public FuncionarioOutput saveFuncionario(@RequestBody FuncionarioInput input) {
		log.info("Recebendo requisição para adicionar um funcionario: " + input.getNome());

		Funcionario funcionario = this.funcionarioService.adicionar(this.mapper.toDomain(input));

		return this.mapper.toOutput(funcionario);
	}

}
