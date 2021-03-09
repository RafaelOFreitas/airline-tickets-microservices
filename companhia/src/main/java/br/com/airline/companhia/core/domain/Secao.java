package br.com.airline.companhia.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@NoArgsConstructor
@Getter
@Setter
public class Secao {

  private Classe classe;
  private Integer quantidadeAssento;
  private Integer quantidadeFila;

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }
}
