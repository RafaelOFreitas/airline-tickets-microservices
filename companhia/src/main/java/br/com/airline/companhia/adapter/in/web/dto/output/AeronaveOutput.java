package br.com.airline.companhia.adapter.in.web.dto.output;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AeronaveOutput {

  private String matricula;

  private String modelo;

  private String tipo;

  private Integer quantidadeAssentoFila;

  private Integer quantidadeFila;

  private String status;

  private OffsetDateTime dataRegistro;
}
