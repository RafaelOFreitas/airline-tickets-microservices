package br.com.airline.companhia.adapter.in.web.dto.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(Include.NON_NULL)
public class RotaOutput {

  @JsonProperty(value = "id_rota", index = 0)
  private Integer id;

  private String origem;

  private String destino;

  private OffsetDateTime dataRegistro;

  private Set<AeronaveOutput> aeronaves;
}
