package br.com.airline.companhia.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
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
