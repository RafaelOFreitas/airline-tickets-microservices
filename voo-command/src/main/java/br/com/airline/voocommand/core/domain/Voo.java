package br.com.airline.voocommand.core.domain;

import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Voo {

  private String origem;
  private String destino;
  private OffsetDateTime horario;
  private Integer quantidadeAssentoFila;
  private Integer quantidadeFila;
  private StatusVoo statusVoo;
  private List<MapaVoo> mapaVoo;
  private OffsetDateTime dataRegistro;
}
