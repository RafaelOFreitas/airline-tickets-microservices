package br.com.airline.companhia.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Aeronave {

  private String nome;
  private String modelo;
  private TipoAeronave tipo;
  private Integer quantidadeAssentoPorFila;
  private Integer quantidadeFila;
  private Status status;

  public void ativarAeronave() {
    this.status = Status.ATIVA;
  }

  public void inativarAeronave() {
    this.status = Status.INATIVA;
  }
}
