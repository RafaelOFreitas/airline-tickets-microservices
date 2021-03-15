package br.com.airline.voocommand.core.domain;

import java.time.OffsetDateTime;
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

  private String id;
  private UUID companhia;
  private Integer rota;
  private String aeronave;
  private String origem;
  private String destino;
  private OffsetDateTime horario;
  private StatusVoo status;
  private MapaVoo mapa;
  private OffsetDateTime dataRegistro;
  private OffsetDateTime dataAtualizacao;
}