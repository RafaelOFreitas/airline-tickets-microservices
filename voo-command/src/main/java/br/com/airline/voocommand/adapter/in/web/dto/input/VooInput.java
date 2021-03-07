package br.com.airline.voocommand.adapter.in.web.dto.input;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class VooInput {

  @NotNull
  private UUID idCompanhia;

  @NotNull
  private Integer idRota;

  @NotBlank
  private String matriculaAeronave;

  @Override
  public String toString() {
    return "VooInput{" +
        "idCompanhia=" + idCompanhia +
        ", idRota=" + idRota +
        ", matriculaAeronave='" + matriculaAeronave + '\'' +
        '}';
  }
}
