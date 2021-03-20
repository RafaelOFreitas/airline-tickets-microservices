package br.com.airline.passagem.adapter.out.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "passagem")
public class PassagemEntity {

  @Transient
  public static final String SEQUENCE_NAME = "passagem_sequence";

  @Id
  private long id;

  private PagamentoEntity pagamento;
}
