package br.com.airline.voocommand.adapter.in.web.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VooInput {

  @NotNull
  @JsonProperty(value = "id_companhia")
  private UUID companhia;

  @NotNull
  @JsonProperty(value = "id_rota")
  private Integer rota;

  @NotBlank
  @JsonProperty(value = "matricula_aeronave")
  private String matriculaAeronave;

  @Override
  public String toString() {
    return "VooInput{" + "" + "id_companhia=" + companhia + ", id_rota=" +
        rota + ", matricula_aeronave='" + matriculaAeronave + '\'' + '}';
  }
}
