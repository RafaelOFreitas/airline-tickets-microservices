package br.com.airline.voocommand.core.domain;

import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Voo {

  private UUID idCompanhia;
  private Integer idRota;
  private String matriculaAeronave;
  private String origem;
  private String destino;
  private OffsetDateTime horario;
  private StatusVoo statusVoo;
  private Set<MapaVoo> mapasVoo;
  private OffsetDateTime dataRegistro;
  private OffsetDateTime dataAtualizacao;
}