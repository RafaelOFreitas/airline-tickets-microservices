package br.com.airline.passagem.core.application.port.out;

import br.com.airline.passagem.core.domain.FormaPagamento;
import br.com.airline.passagem.core.domain.Usuario;

public interface PassagemPersistencePort {
	void comprar(Usuario usuario, FormaPagamento formaPagamento, String valor);
}
