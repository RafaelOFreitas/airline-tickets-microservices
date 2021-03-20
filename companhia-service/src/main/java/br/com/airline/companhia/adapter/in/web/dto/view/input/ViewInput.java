package br.com.airline.companhia.adapter.in.web.dto.view.input;

import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewInput {

  @NotNull
  @ParamName(value = "id_companhia")
  private UUID companhia;

  @NotNull
  @ParamName(value = "id_rota")
  private Integer rota;

  @NotBlank
  @ParamName(value = "matricula_aeronave")
  private String aeronave;
}
