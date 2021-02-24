package br.com.airline.funcionario.core.application.port.in;

import br.com.airline.funcionario.core.domain.Funcionario;

public interface FuncionarioServicePort {
	Funcionario adicionar(Funcionario funcionario);
}
