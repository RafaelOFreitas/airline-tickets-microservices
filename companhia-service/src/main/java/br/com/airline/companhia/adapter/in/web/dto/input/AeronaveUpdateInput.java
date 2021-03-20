package br.com.airline.companhia.adapter.in.web.dto.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Getter
@Setter
public class AeronaveUpdateInput {

  @NotBlank
  private String matricula;

  @NotBlank
  private String modelo;

  @NotNull
  private TipoAeronaveInput tipo;

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }
}
