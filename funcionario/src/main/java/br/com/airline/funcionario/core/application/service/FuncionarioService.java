package br.com.airline.funcionario.core.application.service;

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

}
