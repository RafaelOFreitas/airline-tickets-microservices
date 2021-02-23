package br.com.airline.companhia.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Rota {

  private String origem;
  private String destino;
}
