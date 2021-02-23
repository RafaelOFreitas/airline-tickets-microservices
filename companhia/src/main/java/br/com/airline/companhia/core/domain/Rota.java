package br.com.airline.companhia.core.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Rota {

  private List<Integer> aeronaves;
  private String origem;
  private String destino;
}
