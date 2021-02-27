package br.com.airline.funcionario.adapter.in.web.dto.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioInput {
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private String cpf;
}
