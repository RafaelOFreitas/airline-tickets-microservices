package br.com.airline.companhia.core.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rota {

  private Integer id;
  private String origem;
  private String destino;
  private List<Aeronave> aeronaves;
}
