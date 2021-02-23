package br.com.airline.companhia.core.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Companhia {

  private String nome;
  private String cnpj;
  private Status status;
  private List<Aeronave> aeronaves;
}
