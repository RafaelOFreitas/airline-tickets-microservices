package br.com.airline.companhia.core.domain;

import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Aeronave {

  private UUID id;
  private String nome;
  private String modelo;
  private TipoAeronave tipo;
  private Integer quantidadeAssentoFila;
  private Integer quantidadeFila;
  private Status status;
  private OffsetDateTime dataRegistro;

  public void ativar() {
    this.status = Status.ATIVA;
  }

  public void inativar() {
    this.status = Status.INATIVA;
  }
}
