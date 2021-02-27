package br.com.airline.funcionario.core.application.port.in;

import java.util.List;
import java.util.UUID;

import br.com.airline.funcionario.core.domain.Funcionario;

public interface FuncionarioServicePort {
	Funcionario adicionar(Funcionario funcionario);

	Funcionario atualizar(UUID id, Funcionario funcionario);

	void excluir(UUID id);

	Funcionario buscarPorId(UUID id);

	List<Funcionario> buscarTodos();

}
