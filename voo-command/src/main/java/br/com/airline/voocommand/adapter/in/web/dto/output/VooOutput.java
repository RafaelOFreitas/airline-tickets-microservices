package br.com.airline.voocommand.adapter.in.web.dto.output;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class VooOutput {

  private UUID idCompanhia;
  private Integer idRota;
  private String matriculaAeronave;
  private String origem;
  private String destino;
  private OffsetDateTime horario;
  private String statusVoo;
  private Set<MapaVooOutput> mapasVoo;
  private OffsetDateTime dataRegistro;
  private OffsetDateTime dataAtualizacao;
}
