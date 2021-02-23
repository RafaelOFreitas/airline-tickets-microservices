package br.com.airline.companhia.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Rota {

  private String origem;
  private String destino;
}
