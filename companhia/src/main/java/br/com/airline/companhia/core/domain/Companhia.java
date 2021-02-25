package br.com.airline.companhia.core.domain;

import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Companhia {

  private UUID id;
  private String nome;
  private String cnpj;
  private Status status;
  private OffsetDateTime dataRegistro;

  public Companhia(UUID id) {
    this.id = id;
  }

  public void ativar() {
    this.status = Status.ATIVA;
  }

  public void inativar() {
    this.status = Status.INATIVA;
  }
}
