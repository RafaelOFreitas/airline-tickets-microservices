package br.com.airline.voocommand.adapter.in.web.dto.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class VooOutput {

  @JsonProperty(value = "matricula_aeronave", index = 1)
  private String aeronave;

  @JsonProperty(value = "id_voo", index = 2)
  private String id;

  private String origem;

  private String destino;

  private OffsetDateTime horario;

  private String status;

  private MapaVooOutput mapa;

  private OffsetDateTime dataRegistro;

  private OffsetDateTime dataAtualizacao;
}
