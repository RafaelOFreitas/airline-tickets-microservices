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
public class CompanhiaOutput {

  @JsonProperty(value = "id_companhia", index = 0)
  private UUID id;

  private String nome;

  private String cnpj;

  private String status;

  private OffsetDateTime dataRegistro;
}
