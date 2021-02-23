package br.com.airline.companhia.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Companhia {

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
