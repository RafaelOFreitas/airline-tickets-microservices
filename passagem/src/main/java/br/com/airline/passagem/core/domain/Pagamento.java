package br.com.airline.passagem.core.domain;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Pagamento {
	
	private Usuario usuario;
	private FormaPagamento formaPagamento;
	private BigDecimal valor;

}
