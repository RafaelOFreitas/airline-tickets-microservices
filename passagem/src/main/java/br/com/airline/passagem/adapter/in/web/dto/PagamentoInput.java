package br.com.airline.passagem.adapter.in.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoInput {
	private FormaPagamentoInput formaPagamento;
	private UsuarioInput usuario;
	private String valor;
}
