package br.com.airline.funcionario.core.application.port.out;

import br.com.airline.funcionario.core.domain.Funcionario;

public interface FuncionarioPersistencePort {
	Funcionario adicionar(Funcionario funcionario);
}
