package br.com.airline.funcionario.core.domain.exception;

import java.util.UUID;

public class FuncionarioNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FuncionarioNotFoundException(String message) {
		super(message);
	}

	public FuncionarioNotFoundException(UUID id) {
		this(String.format("Funcionário não pode ser encontrado com o código: %s", id));
	}

}
