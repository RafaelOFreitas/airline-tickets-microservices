package br.com.airline.passagem.core.application.port.in;

import br.com.airline.passagem.core.domain.FormaPagamento;
import br.com.airline.passagem.core.domain.Usuario;

public interface PassagemServicePort {
	void comprar(Usuario usuario, FormaPagamento formaPagamento, String valor);
}
