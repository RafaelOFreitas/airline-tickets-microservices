package br.com.airline.companhia.core.domain;

import java.time.OffsetDateTime;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@NoArgsConstructor
@Getter
@Setter
public class Aeronave {

  private String matricula;
  private String modelo;
  private TipoAeronave tipo;
  private Set<Secao> secoes;
  private Status status;
  private OffsetDateTime dataRegistro;

  public void ativar() {
    this.status = Status.ATIVA;
  }

  public void inativar() {
    this.status = Status.INATIVA;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }
}
