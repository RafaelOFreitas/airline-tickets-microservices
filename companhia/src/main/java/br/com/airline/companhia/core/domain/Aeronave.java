package br.com.airline.companhia.core.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Aeronave {

  private String nome;
  private String modelo;
  private TipoAeronave tipo;
  private Integer quantidadeAssentoPorFila;
  private Integer quantidadeFila;
  private Status status;

  public Aeronave(
      String nome,
      String modelo,
      TipoAeronave tipo,
      Integer quantidadeAssentoPorFila,
      Integer quantidadeFila
  ) {
    this.nome = nome;
    this.modelo = modelo;
    this.tipo = tipo;
    this.quantidadeAssentoPorFila = quantidadeAssentoPorFila;
    this.quantidadeFila = quantidadeFila;
    this.status = Status.ATIVA;
  }

  public void ativarAeronave() {
    this.status = Status.ATIVA;
  }

  public void inativarAeronave() {
    this.status = Status.INATIVA;
  }
}
