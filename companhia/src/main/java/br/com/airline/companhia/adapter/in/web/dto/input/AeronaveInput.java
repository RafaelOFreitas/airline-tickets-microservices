package br.com.airline.companhia.adapter.in.web.dto.input;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AeronaveInput {

  @NotBlank
  private String nome;

  @NotBlank
  private String modelo;

  @NotNull
  private TipoAeronaveInput tipo;

  @NotNull
  private Integer quantidadeAssentoFila;

  @NotNull
  private Integer quantidadeFila;
}
