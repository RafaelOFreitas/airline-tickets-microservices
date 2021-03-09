package br.com.airline.companhia.adapter.in.web.dto.view.output;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SecaoViewOutput {

  private String classe;

  private Integer quantidadeAssento;

  private Integer quantidadeFila;
}
