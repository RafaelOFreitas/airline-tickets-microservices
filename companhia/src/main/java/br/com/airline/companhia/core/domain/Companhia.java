package br.com.airline.companhia.core.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Companhia {

  private String nome;
  private String cnpj;
  private Status status;

  public Companhia(String nome, String cnpj) {
    this.nome = nome;
    this.cnpj = cnpj;
    this.status = Status.ATIVA;
  }

  public void ativarCompanhia() {
    this.status = Status.ATIVA;
  }

  public void inativarCompanhia() {
    this.status = Status.INATIVA;
  }
}
