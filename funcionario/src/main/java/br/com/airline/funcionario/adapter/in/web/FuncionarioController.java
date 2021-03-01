package br.com.airline.funcionario.adapter.in.web;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping("/")
public class FuncionarioController {

	private final FuncionarioServicePort funcionarioService;
	private final FuncionarioMapper mapper;

	@PostMapping("/")
	public FuncionarioOutput saveFuncionario(@RequestBody FuncionarioInput input) {
		log.info("Recebendo requisição para adicionar um funcionario: " + input.getNome());
		Funcionario funcionario = this.funcionarioService.adicionar(this.mapper.toDomain(input));
		return this.mapper.toOutput(funcionario);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FuncionarioOutput> getFuncionarioById(@PathVariable UUID id) {
		log.info("Buscando funcionário: {}", id);
		Funcionario funcionario = this.funcionarioService.buscarPorId(id);
		return ResponseEntity.ok().body(this.mapper.toOutput(funcionario));
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<FuncionarioOutput>> getAllFuncionarios() {
		log.info("Listando todos os funcionários");
		List<Funcionario> todos = this.funcionarioService.buscarTodos();
		return ResponseEntity.ok().body(todos.stream().map(f -> this.mapper.toOutput(f)).collect(Collectors.toList()));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable UUID id) {
		log.info("Excluindo funcionário: {}", id);
		this.funcionarioService.excluir(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<FuncionarioOutput> updateFuncionario(@PathVariable UUID id,
			@RequestBody FuncionarioInput input) {
		log.info("Recebendo requisição para atualizar funcionario {}", id);
		Funcionario funcionarioAtualizado = this.funcionarioService.atualizar(id, this.mapper.toDomain(input));
		return ResponseEntity.ok().body(this.mapper.toOutput(funcionarioAtualizado));
	}
}
