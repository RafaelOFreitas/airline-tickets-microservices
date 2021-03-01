package br.com.airline.funcionario.core.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.airline.funcionario.core.application.port.in.FuncionarioServicePort;
import br.com.airline.funcionario.core.application.port.out.FuncionarioPersistencePort;
import br.com.airline.funcionario.core.domain.Funcionario;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FuncionarioService implements FuncionarioServicePort {

	private final FuncionarioPersistencePort funcionarioPersistence;

	public Funcionario adicionar(Funcionario funcionario) {
		return this.funcionarioPersistence.adicionar(funcionario);
	}

	@Override
	public Funcionario atualizar(UUID id, Funcionario funcionario) {
		return this.funcionarioPersistence.atualizar(id, funcionario);
	}

	@Override
	public void excluir(UUID id) {
		funcionarioPersistence.excluir(id);

	}

	@Override
	public Funcionario buscarPorId(UUID id) {
		return funcionarioPersistence.buscar(id);
	}

	@Override
	public List<Funcionario> buscarTodos() {
		return funcionarioPersistence.buscarTodos();
	}

}
