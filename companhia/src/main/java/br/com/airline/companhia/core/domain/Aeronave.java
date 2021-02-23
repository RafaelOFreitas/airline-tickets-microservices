package br.com.airline.companhia.core.domain;

import java.util.List;
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
  private Integer numeroAssentos;
  private List<Classe> classe;
  private Rota rota;
}
