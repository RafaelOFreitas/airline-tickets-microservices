package br.com.airline.passagem.core.application.service;

import org.springframework.stereotype.Service;

import br.com.airline.passagem.core.application.port.in.PassagemServicePort;
import br.com.airline.passagem.core.application.port.out.PassagemPersistencePort;
import br.com.airline.passagem.core.domain.FormaPagamento;
import br.com.airline.passagem.core.domain.Usuario;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PassagemService implements PassagemServicePort {
	
	private final PassagemPersistencePort passagemPersistence;
	
	@Override
	public void comprar(Usuario usuario, FormaPagamento formaPagamento, String valor) {
		passagemPersistence.comprar(usuario, formaPagamento, valor);
	}

}
