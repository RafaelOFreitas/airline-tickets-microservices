package br.com.airline.voocommand.adapter.out.companhia.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AeronaveDto {

  private String matricula;

  private Integer quantidadeAssentoFila;

  private Integer quantidadeFila;

  private TipoAeronaveDto tipo;
}
