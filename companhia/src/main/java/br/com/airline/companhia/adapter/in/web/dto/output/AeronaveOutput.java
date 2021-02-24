package br.com.airline.companhia.adapter.in.web.dto.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AeronaveOutput {

  @JsonProperty("id_aeronave")
  private UUID id;

  private String nome;

  private String modelo;

  private String tipo;

  private Integer quantidadeAssentoFila;

  private Integer quantidadeFila;

  private String status;

  private OffsetDateTime dataRegistro;
}
