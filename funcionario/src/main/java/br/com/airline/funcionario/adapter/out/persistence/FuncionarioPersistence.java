package br.com.airline.funcionario.adapter.out.persistence;

import org.springframework.stereotype.Repository;

import br.com.airline.funcionario.adapter.out.persistence.entity.FuncionarioEntity;
import br.com.airline.funcionario.adapter.out.persistence.mapper.FuncionarioEntityMapper;
import br.com.airline.funcionario.adapter.out.persistence.repository.FuncionarioRepository;
import br.com.airline.funcionario.core.application.port.out.FuncionarioPersistencePort;
import br.com.airline.funcionario.core.domain.Funcionario;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Repository
@Log4j2
public class FuncionarioPersistence implements FuncionarioPersistencePort {

	private final FuncionarioRepository funcionarioRepository;
	private final FuncionarioEntityMapper mapper;

	public Funcionario adicionar(Funcionario funcionario) {
		log.info("Iniciando transação para salvar funcionario: " + funcionario.getNome());

		FuncionarioEntity entity = this.mapper.toEntity(funcionario);

		entity = this.funcionarioRepository.save(entity);

		return this.mapper.toDomain(entity);
	}

}
