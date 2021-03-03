package br.com.airline.passagem.adapter.out.persistence.entity;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PagamentoEntity {
	
	private UsuarioEntity usuario;
	private FormaPagamentoEntity formaPagamento;
	private BigDecimal valor;

}
