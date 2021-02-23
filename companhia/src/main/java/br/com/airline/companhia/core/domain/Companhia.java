package br.com.airline.companhia.core.domain;

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

  public void ativarCompanhia() {
    this.status = Status.ATIVA;
  }

  public void inativarCompanhia() {
    this.status = Status.INATIVA;
  }
}
