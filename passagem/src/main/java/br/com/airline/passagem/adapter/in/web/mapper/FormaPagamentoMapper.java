package br.com.airline.passagem.adapter.in.web.mapper;

import org.springframework.stereotype.Component;

import br.com.airline.passagem.adapter.in.web.dto.FormaPagamentoInput;
import br.com.airline.passagem.core.domain.FormaPagamento;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class FormaPagamentoMapper {

	public FormaPagamento toDomain(FormaPagamentoInput input) {
		FormaPagamento forma = new FormaPagamento();
		forma.setDescricao(input.getDescricao());
		return forma;
	}
}
