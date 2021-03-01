package br.com.airline.funcionario.adapter.out.persistence;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.airline.funcionario.adapter.out.persistence.entity.FuncionarioEntity;
import br.com.airline.funcionario.adapter.out.persistence.mapper.FuncionarioEntityMapper;
import br.com.airline.funcionario.adapter.out.persistence.repository.FuncionarioRepository;
import br.com.airline.funcionario.core.application.port.out.FuncionarioPersistencePort;
import br.com.airline.funcionario.core.domain.Funcionario;
import br.com.airline.funcionario.core.domain.exception.FuncionarioNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Repository
@Log4j2
public class FuncionarioPersistence implements FuncionarioPersistencePort {

	private final FuncionarioRepository funcionarioRepository;
	private final FuncionarioEntityMapper mapper;

	public Funcionario adicionar(Funcionario funcionario) {
		log.info("Iniciando transação para salvar funcionario {} ", funcionario.getNome());
		FuncionarioEntity entity = this.mapper.toEntity(funcionario);
		entity = this.funcionarioRepository.save(entity);
		return this.mapper.toDomain(entity);
	}

	public Funcionario atualizar(UUID id, Funcionario funcionario) {
		log.info("Iniciando transação para atualizar dados do funcionário: " + id);
	    FuncionarioEntity funcionarioEntity = this.getFuncionarioEntity(id);
	    this.mapper.copyProperties(funcionario, funcionarioEntity);
	    funcionarioEntity = this.funcionarioRepository.save(funcionarioEntity);
	    return this.mapper.toDomain(funcionarioEntity);
	}

	public void excluir(UUID id) {
		funcionarioRepository.deleteById(id);
	}

	public Funcionario buscar(UUID id) {
		log.info("Iniciando transação para buscar dados do funcionário: {} ", id);
		FuncionarioEntity funcionarioEntity = this.getFuncionarioEntity(id);
		return this.mapper.toDomain(funcionarioEntity);
	}

	public List<Funcionario> buscarTodos() {
		log.info("Iniciando transação para buscar dados de todos funcionários");
		return funcionarioRepository.findAll().stream().map(f -> this.mapper.toDomain(f)).collect(Collectors.toList());
	}

	protected FuncionarioEntity getFuncionarioEntity(UUID id) {
		return this.funcionarioRepository.findById(id).orElseThrow(() -> new FuncionarioNotFoundException(id));
	}

}
