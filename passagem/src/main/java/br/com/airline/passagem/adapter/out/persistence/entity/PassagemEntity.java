package br.com.airline.passagem.adapter.out.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "passagem")
public class PassagemEntity {

	@Transient
	public static final String SEQUENCE_NAME = "passagem_sequence";

	@Id
	private long id;

	private PagamentoEntity pagamento;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PagamentoEntity getPagamento() {
		return pagamento;
	}

	public void setPagamento(PagamentoEntity pagamento) {
		this.pagamento = pagamento;
	}
	
	

	
}
