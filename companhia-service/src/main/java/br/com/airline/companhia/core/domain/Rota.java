package br.com.airline.companhia.core.domain;

import java.time.OffsetDateTime;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rota {

  private Integer id;
  private String origem;
  private String destino;
  private OffsetDateTime dataRegistro;
  private Set<Aeronave> aeronaves;

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }
}
